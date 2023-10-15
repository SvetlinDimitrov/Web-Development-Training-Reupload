package com.likebookapp.service;

import com.likebookapp.model.entity.PostEntity;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelperService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserEntity getUserById(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public PostEntity getPostById(Long id){
        return postRepository.findById(id).orElseThrow();
    }
}
