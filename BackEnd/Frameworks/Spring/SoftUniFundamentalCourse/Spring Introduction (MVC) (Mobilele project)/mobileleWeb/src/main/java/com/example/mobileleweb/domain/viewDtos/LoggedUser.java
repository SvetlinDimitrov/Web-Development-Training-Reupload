package com.example.mobileleweb.domain.viewDtos;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {
    private String id;
    private String username;
    private Boolean isAdmin;
}
