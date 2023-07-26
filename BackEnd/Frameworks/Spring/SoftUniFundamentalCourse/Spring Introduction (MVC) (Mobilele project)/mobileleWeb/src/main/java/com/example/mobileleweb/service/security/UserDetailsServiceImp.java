package com.example.mobileleweb.service.security;

import com.example.mobileleweb.domain.entity.UserEntity;
import com.example.mobileleweb.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::toUserSec)
                .orElseThrow(() -> new UsernameNotFoundException("no user found"));
    }

    private Collection<? extends GrantedAuthority> getSimpleAuthority(UserEntity userEntity) {
        return List.of(new SimpleGrantedAuthority("ROLE_"+userEntity.getRole().role.name()));
    }
    private User toUserSec (UserEntity userEntity){
        return new User(userEntity.getUsername(), userEntity.getPassword(), getSimpleAuthority(userEntity));
    }
}
