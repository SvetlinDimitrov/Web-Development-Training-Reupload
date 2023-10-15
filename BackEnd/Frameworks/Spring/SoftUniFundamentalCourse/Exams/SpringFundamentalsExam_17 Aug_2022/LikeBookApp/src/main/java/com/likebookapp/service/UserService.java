package com.likebookapp.service;

import com.likebookapp.model.dtos.UserRegisterDto;
import com.likebookapp.model.dtos.UserView;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserRegisterDto userRegisterDto) {
        UserEntity user = userRegisterDto.toUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public UserView getLoggedUserView(Long id) {
        return userRepository.findById(id)
                .map(UserView::new)
                .orElseThrow();
    }
}
