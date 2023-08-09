package com.example.mobilelegraderebuild.domain.entity;

import com.example.mobilelegraderebuild.domain.constants.BaseEntity;
import com.example.mobilelegraderebuild.domain.viewDtos.RegisterUserDto;
import com.example.mobilelegraderebuild.domain.viewDtos.SecurityViewUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
