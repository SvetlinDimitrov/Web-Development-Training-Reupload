package com.example.mobileleweb.service.User;

import com.example.mobileleweb.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
}
