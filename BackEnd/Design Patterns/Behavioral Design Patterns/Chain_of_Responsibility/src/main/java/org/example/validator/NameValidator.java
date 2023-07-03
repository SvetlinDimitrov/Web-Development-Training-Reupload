package org.example.validator;

import org.example.User;

public class NameValidator extends BaseValidator{

    public NameValidator(RegisterValidation registerValidation) {
        super(registerValidation);
    }

    @Override
    public boolean validate(User user) {
        if(user.getName().isBlank()){
            System.out.println("Username is notGood");
            return false;
        }
        return nextValidator(user);
    }
}
