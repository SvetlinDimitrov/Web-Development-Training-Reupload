package com.example.battleships.exeptions.userConstraint.uniqueName;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNameUser.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserConstraintName {
    String message () default "";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
