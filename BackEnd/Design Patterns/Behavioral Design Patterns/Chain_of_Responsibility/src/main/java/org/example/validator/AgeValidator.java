package org.example.validator;

import org.example.User;

public class AgeValidator extends BaseValidator{
    public AgeValidator(RegisterValidation registerValidation) {
        super(registerValidation);
    }

    @Override
    public boolean validate(User user) {
        if(user.getAge() == null || user.getAge() < 18){
            System.out.println("This sait is not legal for you to visit , grow up");
            return false;
        }
        return nextValidator(user);
    }
}
