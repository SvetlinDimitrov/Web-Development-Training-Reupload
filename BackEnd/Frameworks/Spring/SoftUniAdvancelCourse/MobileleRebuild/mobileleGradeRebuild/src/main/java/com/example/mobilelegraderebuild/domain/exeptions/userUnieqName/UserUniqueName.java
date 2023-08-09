package com.example.mobilelegraderebuild.domain.exeptions.userUnieqName;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserUniqueNameValidator.class)
public @interface UserUniqueName {
    String message () default "";
    Class<?> [] groups () default {};
    Class<? extends Payload> [] payload () default {};
}
