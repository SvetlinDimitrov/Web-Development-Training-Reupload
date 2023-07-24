package com.example.mobileleweb.service.security;

import com.example.mobileleweb.domain.entity.User;
import com.example.mobileleweb.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::toUserSec)
                .orElseThrow(() -> new UsernameNotFoundException("no user found"));
    }

    private Collection<? extends GrantedAuthority> getSimpleAuthority(User user) {
        return List.of(new SimpleGrantedAuthority(user.getRole().getRole().name()));
    }
    private org.springframework.security.core.userdetails.User toUserSec (User user){
        return new org.springframework.security.core.userdetails.User
                (user.getUsername(),user.getPassword(), getSimpleAuthority(user));
    }
}
