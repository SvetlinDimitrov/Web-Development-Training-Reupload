package com.example.demoaop;

import com.example.demoaop.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final UserServiceImp userServiceImp;

    public Main(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("sasho", "");
        User user2 = new User("sasho2", "2");

        userServiceImp.registerUser(user);
        userServiceImp.login(user);

        userServiceImp.registerUser(user2);
        userServiceImp.login(user2);

        userServiceImp.getAllUsers().forEach(e-> System.out.println(e.getName()));

    }
}
