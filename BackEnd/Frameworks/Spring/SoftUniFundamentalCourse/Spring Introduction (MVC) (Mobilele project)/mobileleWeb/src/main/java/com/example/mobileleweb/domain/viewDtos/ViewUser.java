package com.example.mobileleweb.domain.viewDtos;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.Offer;
import com.example.mobileleweb.domain.entity.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ViewUser extends User {
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private Role role;
    private String imageUrl;
    private LocalDate created;
    private LocalDate modified;
    private List<Offer> offers = new ArrayList<>();

    public ViewUser(UserEntity userEntity) {
        super(userEntity.getUsername(), userEntity.getPassword(),
                List.of(new SimpleGrantedAuthority(userEntity.getRole().getRole().name())));
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.isActive = userEntity.getIsActive();
        this.role = userEntity.getRole().role;
        this.imageUrl = userEntity.getImageUrl();
        this.created = userEntity.getCreated();
        this.modified = userEntity.getModified();
    }

    public String getId() {
        return id;
    }

    public ViewUser setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public ViewUser setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public ViewUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ViewUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ViewUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public ViewUser setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public ViewUser setRole(Role role) {
        this.role = role;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ViewUser setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ViewUser setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public LocalDate getModified() {
        return modified;
    }

    public ViewUser setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public ViewUser setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

}
