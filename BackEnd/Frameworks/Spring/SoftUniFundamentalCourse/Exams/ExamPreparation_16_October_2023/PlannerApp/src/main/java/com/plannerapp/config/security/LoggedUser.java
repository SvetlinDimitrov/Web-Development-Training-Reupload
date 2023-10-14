package com.plannerapp.config.security;

import com.plannerapp.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Setter
@Getter
public class LoggedUser extends User {

    private Long id;
    private String username;

    public LoggedUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.id = user.getId();
        this.username = user.getUsername();
    }
}
