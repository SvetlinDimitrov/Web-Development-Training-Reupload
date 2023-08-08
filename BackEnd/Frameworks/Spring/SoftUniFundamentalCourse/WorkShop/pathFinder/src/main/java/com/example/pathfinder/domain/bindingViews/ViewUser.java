package com.example.pathfinder.domain.bindingViews;


import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.UserEntity;
import lombok.*;

import java.util.List;
import java.util.Objects;
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
    private Set<ViewRole> roles;
    private Level level;
    private List<ViewRoute> route;
    private List<ViewPicture> pictures;
    private List<ViewMessage> messages;
    private boolean isAdmin;

    public ViewUser(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.roles = user.getRoles()
                .stream()
                .map(ViewRole::new)
                .collect(Collectors.toSet());
        this.level = user.getLevel();
        this.route = user.getRoute()
                .stream()
                .map(ViewRoute::new)
                .collect(Collectors.toList());
        this.pictures = user.getPictures()
                .stream()
                .map(ViewPicture::new)
                .collect(Collectors.toList());
        this.messages = user.getMessages()
                .stream()
                .map(ViewMessage::new)
                .collect(Collectors.toList());
        this.isAdmin = roles.stream()
                .anyMatch(r-> r.getRole().equals(RoleConstant.ADMIN));

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewUser viewUser = (ViewUser) o;
        return isAdmin == viewUser.isAdmin && Objects.equals(id, viewUser.id) && Objects.equals(username, viewUser.username) && Objects.equals(fullName, viewUser.fullName) && Objects.equals(age, viewUser.age) && Objects.equals(email, viewUser.email) && Objects.equals(roles, viewUser.roles) && level == viewUser.level && Objects.equals(route, viewUser.route) && Objects.equals(pictures, viewUser.pictures) && Objects.equals(messages, viewUser.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, fullName, age, email, roles, level, route, pictures, messages, isAdmin);
    }
}
