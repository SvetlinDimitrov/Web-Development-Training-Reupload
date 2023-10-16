package com.example.spotifyplaylistapp.config.security;

import com.example.spotifyplaylistapp.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
@Setter
public class LoggedUser extends User {

    private Long id;

    public LoggedUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.id = user.getId();
    }
}
