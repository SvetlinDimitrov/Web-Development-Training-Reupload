package com.example.pathfinder.domain.dtos;
import com.example.pathfinder.domain.bindingViews.*;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.Role;
import com.example.pathfinder.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUserDto {

    public LoggedUserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public LoggedUserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public LoggedUserDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public LoggedUserDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public LoggedUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public LoggedUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public LoggedUserDto setRoles(Set<ViewRoles> roles) {
        this.roles = roles;
        return this;
    }

    public LoggedUserDto setLevel(Level level) {
        this.level = level;
        return this;
    }

    public LoggedUserDto setComments(List<ViewComments> comments) {
        this.comments = comments;
        return this;
    }

    public LoggedUserDto setRoute(List<ViewRoute> route) {
        this.route = route;
        return this;
    }

    public LoggedUserDto setPictures(List<ViewPictures> pictures) {
        this.pictures = pictures;
        return this;
    }

    public LoggedUserDto setMessages(List<ViewMessages> messages) {
        this.messages = messages;
        return this;
    }

    public LoggedUserDto setRecipients(List<ViewMessages> recipients) {
        this.recipients = recipients;
        return this;
    }

    private Long id;
    private String username;
    private String fullName;
    private Integer age;
    private String password;
    private String email;
    private Set<ViewRoles> roles;
    private Level level;
    private List<ViewComments> comments;
    private List<ViewRoute> route;
    private List<ViewPictures> pictures;
    private List<ViewMessages> messages;
    private List<ViewMessages> recipients;

    public boolean isAdmin(){
        return roles.stream().map(ViewRoles::getRole).anyMatch(r->r.equals(RoleConstant.ADMIN));
    }
}
