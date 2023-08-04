package com.example.pathfinder.domain.bindingViews;


import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.UserEntity;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewUser  {

    private Long id;
    private String username;
    private String fullName;
    private Integer age;
    private String email;
    private Set<ViewRoles> roles;
    private Level level;
    private List<ViewRoute> route;
    private List<ViewPictures> pictures;
    private List<ViewMessages> messages;
    private boolean isAdmin;

    public ViewUser(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.roles = user.getRoles()
                .stream()
                .map(ViewRoles::new)
                .collect(Collectors.toSet());
        this.level = user.getLevel();
        this.route = user.getRoute()
                .stream()
                .map(ViewRoute::new)
                .collect(Collectors.toList());
        this.pictures = user.getPictures()
                .stream()
                .map(ViewPictures::new)
                .collect(Collectors.toList());
        this.messages = user.getMessages()
                .stream()
                .map(ViewMessages::new)
                .collect(Collectors.toList());
        this.isAdmin = roles.stream()
                .anyMatch(r-> r.getRole().equals(RoleConstant.ADMIN));

    }
}
