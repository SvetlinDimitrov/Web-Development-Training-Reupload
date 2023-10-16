package com.example.spotifyplaylistapp.validations.email;

import com.example.spotifyplaylistapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmailConstant, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userRepository
                .findByEmail(username)
                .isEmpty();
    }
}

