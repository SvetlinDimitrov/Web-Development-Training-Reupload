package com.resellerapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;


@Getter
@Setter
public class UserPrincipal extends User {

    private String username;
    private Long id;

    public UserPrincipal(String username , String password , Long id){
        super(username , password , List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.username = username;
        this.id = id;
    }
}
