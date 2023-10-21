package com.dictionaryapp.service;

import com.dictionaryapp.model.dtos.UserLoginDto;
import com.dictionaryapp.model.dtos.UserRegisterDto;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(UserRegisterDto userRegisterDto) {
        userRepository.save(userRegisterDto.toUser());
    }

    public String login(UserLoginDto userLoginDto) {
        Optional<User> user = userRepository.findByUsername(userLoginDto.getUsername());
        return user.isPresent() &&
                user.get().getPassword().equals(userLoginDto.getPassword())
                ? user.get().getUsername() : null;

    }
}
