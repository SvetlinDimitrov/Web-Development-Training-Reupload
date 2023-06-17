package com.example.battleships.exeptions.userConstraint.uniqueEmail;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailUser.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserConstraintEmail {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
