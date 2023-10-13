package com.resellerapp.service;

import com.resellerapp.config.UserPrincipal;
import com.resellerapp.repository.UserRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserDetailServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loggedUser(username);
    }

    private UserPrincipal loggedUser(String username){
        return userRepository.findByUsername(username)
                .map(user -> new UserPrincipal(user.getUsername() , user.getPassword() , user.getId()))
                .orElseThrow( () -> new UsernameNotFoundException(username));
    }
}
