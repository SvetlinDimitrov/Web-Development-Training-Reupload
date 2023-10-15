package com.likebookapp.config.security;

import com.likebookapp.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
@Setter
public class UserLogged extends User {

    private Long id;
    public UserLogged(UserEntity user) {
        super(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.id = user.getId();
    }
}
