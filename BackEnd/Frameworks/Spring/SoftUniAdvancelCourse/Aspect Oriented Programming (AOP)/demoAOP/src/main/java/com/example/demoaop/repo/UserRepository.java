package com.example.demoaop.repo;

import com.example.demoaop.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Component
public class UserRepository {

    private final HashMap<String , User> map = new HashMap<>();


    public List<User> findAll() {
        return map.values().stream().toList();
    }


    public void save(User user) {
        map.put(user.getName() , user);
    }

    public User findUserByName(String username) {
        return map.get(username);
    }
}
