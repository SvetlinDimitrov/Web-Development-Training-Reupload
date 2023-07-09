package org.example.validator;

import org.example.User;

public class PasswordValidator extends BaseValidator{
    public PasswordValidator(RegisterValidation registerValidation) {
        super(registerValidation);
    }

    @Override
    public boolean validate(User user) {
        if(user.getPassword().isBlank() ||
                user.getConfirmPassword().isBlank() ||
                !user.getPassword().equals(user.getConfirmPassword())){
            System.out.println("Problem with the passwords");
            return false;
        }
        return nextValidator(user);
    }
}
