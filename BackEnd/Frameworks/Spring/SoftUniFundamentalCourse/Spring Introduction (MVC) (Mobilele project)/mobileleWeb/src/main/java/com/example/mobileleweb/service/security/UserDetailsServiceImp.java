package com.example.mobileleweb.service.security;

import com.example.mobileleweb.domain.entity.UserEntity;
import com.example.mobileleweb.domain.viewDtos.SecurityViewUser;
import com.example.mobileleweb.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::toUserSec)
                .orElseThrow(() -> new UsernameNotFoundException("no user found"));
    }
    private SecurityViewUser toUserSec (UserEntity userEntity){
        return new SecurityViewUser(userEntity);
    }
}
