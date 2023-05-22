package com.example.springintro;

import com.example.springintro.models.Accounts;
import com.example.springintro.models.User;
import com.example.springintro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("yes");
        User user = new User();
        user.setUsername("Peshaso");
        user.setAge(15);
        user.getAccounts().add(new Accounts());
        this.userService.register(user);
    }
}
