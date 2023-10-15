package com.resellerapp.service;

import com.resellerapp.model.dtos.RegisterUserDto;
import com.resellerapp.model.dtos.ViewOffer;
import com.resellerapp.model.dtos.ViewUser;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean usedUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean usedEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public void register(RegisterUserDto registerUserDto) {
        User user = registerUserDto.toUser.get();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

    }

    @Transactional
    public ViewUser getViewUser(Long id) {
        return new ViewUser(userRepository.findById(id).orElseThrow(() -> new RuntimeException("no user exist")));
    }

    @Transactional
    public List<ViewUser> getAllViewUsersWithoutCurrent(Long id) {
        return userRepository.findAll()
                .stream()
                .filter( u -> !u.getId().equals(id))
                .map(ViewUser::new)
                .collect(Collectors.toList());
    }
}
