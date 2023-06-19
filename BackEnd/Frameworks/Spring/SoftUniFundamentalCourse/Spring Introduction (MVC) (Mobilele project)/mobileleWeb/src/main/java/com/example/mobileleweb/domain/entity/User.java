package com.example.mobileleweb.domain.entity;

import com.example.mobileleweb.domain.constants.BaseEntity;
import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.viewDtos.LoggedUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    @ManyToMany
    @JoinTable(
            uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "role_id" }) },
            name = "roles_users",
            joinColumns = @JoinColumn(unique = false , referencedColumnName = "id" , name = "user_id"),
            inverseJoinColumns = @JoinColumn(unique = false ,referencedColumnName = "id" , name = "role_id")
    )
    private List<UserRole> roles = new ArrayList<>();

    @Column(name = "image_url",columnDefinition = "varchar(255)")
    private String imageUrl;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate created;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate modified;

    public LoggedUser toLoggedUser(){
        return LoggedUser.builder()
                .id(getId())
                .username(username)
                .isAdmin(roles.contains(Role.Admin))
                .build();

    }
}
