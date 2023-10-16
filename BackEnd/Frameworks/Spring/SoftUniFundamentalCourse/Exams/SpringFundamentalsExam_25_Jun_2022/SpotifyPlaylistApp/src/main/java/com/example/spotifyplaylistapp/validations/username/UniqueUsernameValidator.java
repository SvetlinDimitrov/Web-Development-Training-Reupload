package com.example.spotifyplaylistapp.validations.username;

import com.example.spotifyplaylistapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsernameConstant , String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userRepository
                .findByUsername(username)
                .isEmpty();
    }
}

