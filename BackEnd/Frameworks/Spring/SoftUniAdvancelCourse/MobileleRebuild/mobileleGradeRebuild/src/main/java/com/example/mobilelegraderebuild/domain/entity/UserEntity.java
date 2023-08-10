package com.example.mobilelegraderebuild.domain.entity;

import com.example.mobilelegraderebuild.domain.constants.BaseEntity;
import com.example.mobilelegraderebuild.domain.viewDtos.RegisterUserDto;
import com.example.mobilelegraderebuild.domain.viewDtos.SecurityViewUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(columnDefinition = "varchar(255)" , unique = true)
    private String username;

    @Column(columnDefinition = "varchar(255)")
    private String password;

    @Column(name = "first_name" , columnDefinition = "varchar(255)")
    private String firstName;


    @Column(name = "last_name" , columnDefinition = "varchar(255)")
    private String lastName;

    @Column(name = "is_active" , columnDefinition = "bit(1)")
    private Boolean isActive;

    @ManyToOne
    private UserRole role;

    @Column(name = "image_url",columnDefinition = "varchar(255)")
    private String imageUrl;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate created;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate modified;


    @OneToMany(mappedBy = "seller")
    private List<Offer> offers = new ArrayList<>();

    public UserEntity (RegisterUserDto userDto) {
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();

    }

    public SecurityViewUser toUserView(){
        return new SecurityViewUser(this);
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEntity setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public UserEntity setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public UserEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public UserEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public UserEntity setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    public UserEntity setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(isActive, that.isActive) && Objects.equals(role, that.role) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(created, that.created) && Objects.equals(modified, that.modified) && Objects.equals(offers, that.offers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, isActive, role, imageUrl, created, modified, offers);
    }
}
