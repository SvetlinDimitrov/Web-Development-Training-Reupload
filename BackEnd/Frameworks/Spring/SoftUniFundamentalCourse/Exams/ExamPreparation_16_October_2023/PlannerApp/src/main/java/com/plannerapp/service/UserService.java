package com.plannerapp.service;

import com.plannerapp.model.dtos.UserLoginDto;
import com.plannerapp.model.dtos.UserRegisterDto;
import com.plannerapp.model.dtos.ViewUser;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.repo.UserRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " does not exist"));
    }

    public boolean isUniqueUsername(String username) {
        return userRepository.findByUsername(username).isEmpty();
    }

    public boolean isUniqueEmail(String email) {
        return userRepository.findByEmail(email).isEmpty();
    }

    public void registerUser(UserRegisterDto userRegisterDto) {

        UserEntity user = userRegisterDto.toUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

    @Transactional
    public ViewUser getViewUser(Long id) {
        return userRepository.findById(id)
                .map(ViewUser::new)
                .orElseThrow(() -> new IllegalArgumentException("no user found with that id"));
    }
}
