package org.example.validator;

import org.example.User;

public abstract class BaseValidator implements RegisterValidation{
    protected RegisterValidation registerValidation;

    public boolean nextValidator(User user){
        if(registerValidation == null){
            return true;
        }
        return registerValidation.validate(user);
    }

    public BaseValidator(RegisterValidation registerValidation) {
        this.registerValidation = registerValidation;
    }
}
