package org.example.validator;

import org.example.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator extends BaseValidator{
    public EmailValidator(RegisterValidation registerValidation) {
        super(registerValidation);
    }

    @Override
    public boolean validate(User user) {
        Pattern pattern = Pattern.compile("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" +
                ")*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(user.getEmail());
        if(!matcher.find()){
            System.out.println("Problem with the email");
            return false;
        }
        return nextValidator(user);
    }
}
