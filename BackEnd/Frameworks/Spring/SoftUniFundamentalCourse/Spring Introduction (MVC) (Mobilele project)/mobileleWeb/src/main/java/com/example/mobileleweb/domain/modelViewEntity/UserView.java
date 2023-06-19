package com.example.mobileleweb.domain.modelViewEntity;

import com.example.mobileleweb.domain.entity.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
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

}
