package com.example.battleships.exeptions.userConstraint.matchPassword;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConfirmPasswordUser.class)
@Target({ElementType.FIELD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserConstraintConfirmPassword {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
