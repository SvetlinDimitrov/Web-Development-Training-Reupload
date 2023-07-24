package com.example.mobileleweb.domain.exeptions.userUnieqName;


import com.example.mobileleweb.domain.modelViewEntity.UserView;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;
import com.example.mobileleweb.service.User.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserUniqueNameValidator implements ConstraintValidator <UserUniqueName , RegisterUserDto> {

    private UserService userService;

    @Override
    public void initialize(UserUniqueName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RegisterUserDto userDto, ConstraintValidatorContext context) {
        return userService.checkIfUsernameAlreadyExists(userDto.getUsername());
    }
}
