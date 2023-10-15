package com.likebookapp.model.dtos;


import com.likebookapp.model.entity.UserEntity;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserView {

    private Long id;
    private String username;
    private String email;
    private List<PostView> ownPosts;

    public UserView (UserEntity user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.ownPosts = user.getOwnPosts()
                .stream()
                .map(PostView::new)
                .collect(Collectors.toList());
    }
}
