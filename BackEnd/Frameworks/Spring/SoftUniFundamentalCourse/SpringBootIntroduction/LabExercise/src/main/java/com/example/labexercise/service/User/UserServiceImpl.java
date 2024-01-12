package com.example.labexercise.service.User;

import com.example.labexercise.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
}
