package com.example.mobileleweb.domain.entity;

import com.example.mobileleweb.domain.constants.BaseEntity;
import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.viewDtos.LoggedUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User extends BaseEntity {

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

    public LoggedUser toLoggedUser(){
        return LoggedUser.builder()
                .id(getId())
                .username(username)
                .isAdmin(role.getRole().equals(Role.Admin))
                .build();

    }
}
