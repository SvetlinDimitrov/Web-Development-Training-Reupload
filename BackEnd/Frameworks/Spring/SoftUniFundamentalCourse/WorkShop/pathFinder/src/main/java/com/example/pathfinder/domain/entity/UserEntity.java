package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import com.example.pathfinder.domain.constants.Level;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private Integer age;

    @Column
    private String password;

    @Column
    private String email;

    @ManyToMany(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "roles_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    @Column
    private Level level;

    @OneToMany(mappedBy = "author" )
    private List<Comment> comments;

    @OneToMany(mappedBy = "author" )
    private List<Route> route;

    @OneToMany(mappedBy = "author" )
    private List<Picture> pictures;

    @OneToMany(mappedBy = "author")
    private List<Message> messages;

    @OneToMany(mappedBy = "recipient" )
    private List<Message> recipients;

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public UserEntity setLevel(Level level) {
        this.level = level;
        return this;
    }

    public UserEntity setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public UserEntity setRoute(List<Route> route) {
        this.route = route;
        return this;
    }

    public UserEntity setPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public UserEntity setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public UserEntity setRecipients(List<Message> recipients) {
        this.recipients = recipients;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity user = (UserEntity) o;
        return Objects.equals(username, user.username) && Objects.equals(fullName, user.fullName) && Objects.equals(age, user.age) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(roles, user.roles) && level == user.level && Objects.equals(comments, user.comments) && Objects.equals(route, user.route) && Objects.equals(pictures, user.pictures) && Objects.equals(messages, user.messages) && Objects.equals(recipients, user.recipients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, fullName, age, password, email, roles, level, comments, route, pictures, messages, recipients);
    }
}
