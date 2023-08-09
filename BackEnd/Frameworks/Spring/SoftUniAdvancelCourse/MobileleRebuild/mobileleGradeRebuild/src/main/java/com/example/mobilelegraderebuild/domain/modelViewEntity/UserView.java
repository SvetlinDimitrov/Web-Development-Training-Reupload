package com.example.mobilelegraderebuild.domain.modelViewEntity;

import com.example.mobilelegraderebuild.domain.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserView {

    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private UserRole role;
    private String imageUrl;
    private LocalDate created;
    private LocalDate modified;

    public UserView setId(String id) {
        this.id = id;
        return this;
    }

    public UserView setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserView setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserView setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserView setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserView setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public UserView setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public UserView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public UserView setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public UserView setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserView view = (UserView) o;
        return Objects.equals(id, view.id) && Objects.equals(username, view.username) && Objects.equals(password, view.password) && Objects.equals(firstName, view.firstName) && Objects.equals(lastName, view.lastName) && Objects.equals(isActive, view.isActive) && Objects.equals(role, view.role) && Objects.equals(imageUrl, view.imageUrl) && Objects.equals(created, view.created) && Objects.equals(modified, view.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, isActive, role, imageUrl, created, modified);
    }
}
