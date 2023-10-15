package com.likebookapp.service;

import com.likebookapp.config.security.UserLogged;
import com.likebookapp.model.dtos.PostCreateDto;
import com.likebookapp.model.dtos.PostView;
import com.likebookapp.model.entity.PostEntity;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final MoodRepository moodRepository;
    private final PostRepository postRepository;
    private final HelperService helperService;
    private final UserRepository userRepository;

    @Transactional
    public void addPost(PostCreateDto postCreateDto, Long id) {
        UserEntity user = helperService.getUserById(id);
        PostEntity postEntity = new PostEntity();
        postEntity.setContent(postCreateDto.getContent());
        postEntity.setMoodEntities(moodRepository.findByName(postCreateDto.getMood()).orElseThrow());
        postEntity.setUser(user);
        postRepository.save(postEntity);

        user.getOwnPosts().add(postEntity);
        userRepository.save(user);

    }

    @Transactional
    public List<PostView> getAllPostsWithoutLoggedUser(Long id) {
        return postRepository.findAll()
                .stream()
                .filter(p -> helperService.getUserById(id).getOwnPosts().stream().noneMatch(userPost -> userPost.getId().equals(p.getId())))
                .map(PostView::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Modifying
    public void removePost(Long postId) {
        PostEntity post = postRepository.findById(postId).orElseThrow();
        post.getUserLikes()
                .forEach(user-> {
                    user.getLikedPosts().remove(post);
                    userRepository.save(user);
                });
        UserEntity owner = post.getUser();
        owner.getOwnPosts().remove(post);
        userRepository.save(owner);

        postRepository.delete(post);
    }

    @Transactional
    @Modifying
    public void likePost(Long id, UserLogged userLogged) {
        PostEntity post = postRepository.findById(id).orElseThrow();
        UserEntity user = userRepository.findById(userLogged.getId()).orElseThrow();

        if(!post.getUserLikes().contains(user)){
            user.getLikedPosts().add(post);
            userRepository.save(user);

            post.getUserLikes().add(user);
            postRepository.save(post);
        }
    }
}
