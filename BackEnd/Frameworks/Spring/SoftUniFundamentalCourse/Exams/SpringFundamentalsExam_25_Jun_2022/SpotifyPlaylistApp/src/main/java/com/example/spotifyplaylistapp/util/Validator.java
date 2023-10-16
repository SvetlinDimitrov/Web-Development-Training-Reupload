package com.example.spotifyplaylistapp.util;

import com.example.spotifyplaylistapp.model.dtos.UserRegisterDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.function.BiConsumer;


public class Validator {

    public static BiConsumer<UserRegisterDto, BindingResult> checkPasswords =
            (dto, result) -> {
                if (dto.getPassword() == null || dto.getConfirmPassword() == null ||
                        dto.getConfirmPassword().isBlank() || dto.getPassword().isBlank() ||
                        !dto.getPassword().equals(dto.getConfirmPassword())) {
                    result.addError(new FieldError("registerDto", "confirmPassword", "not matching passwords"));
                }
            };
}
