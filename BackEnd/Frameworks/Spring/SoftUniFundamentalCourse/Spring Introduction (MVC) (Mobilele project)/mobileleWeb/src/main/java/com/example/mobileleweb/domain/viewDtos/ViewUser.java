package com.example.mobileleweb.domain.viewDtos;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.Offer;
import com.example.mobileleweb.domain.entity.UserRole;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class ViewUser {
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
}
