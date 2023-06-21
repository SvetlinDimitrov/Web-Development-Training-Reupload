package com.example.battleships.domain.entity;

import com.example.battleships.domain.bindingViews.ViewUser;
import com.example.battleships.domain.constants.DefaultEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends DefaultEntity {

    @Column(unique = true , columnDefinition = "varchar(255)")
    private String username;

    @Column(columnDefinition = "varchar(255)")
    private String fullName;
    //◦ The length of the values should be between 5 and 20 characters long (both numbers are INCLUSIVE)
    @Column(columnDefinition = "varchar(255)")
    private String password;
    //◦ The length of the values should be more than 3 characters long (INCLUSIVE)
    @Column(unique = true ,columnDefinition = "varchar(255)")
    private String email;

    // ◦ The values should contain a '@' symbol
    //◦ The values should be unique in the database
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.MERGE)
    private List<Ship> ships = new ArrayList<>();

    public ViewUser toViewUser(){
        return ViewUser.builder()
                .username(username)
                .fullName(fullName)
                .password(password)
                .email(email)
                .build();
    }

}
