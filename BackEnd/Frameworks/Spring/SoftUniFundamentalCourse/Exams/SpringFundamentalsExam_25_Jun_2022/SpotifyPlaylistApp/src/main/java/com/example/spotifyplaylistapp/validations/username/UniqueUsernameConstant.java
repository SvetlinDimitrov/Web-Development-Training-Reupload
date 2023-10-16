package com.example.spotifyplaylistapp.validations.username;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsernameConstant {
    String message() default "username MUST BE UNIQUE";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}