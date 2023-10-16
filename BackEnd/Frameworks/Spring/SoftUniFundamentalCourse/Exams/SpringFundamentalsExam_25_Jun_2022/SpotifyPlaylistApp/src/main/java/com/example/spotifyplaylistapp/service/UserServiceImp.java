package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dtos.SongView;
import com.example.spotifyplaylistapp.model.dtos.UserRegisterDto;
import com.example.spotifyplaylistapp.model.dtos.UserView;
import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImp {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserRegisterDto registerDto) {
        UserEntity user = registerDto.toUserEntity();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public UserView getViewUser(Long id) {
        return userRepository.findById(id)
                .map(UserView::new)
                .orElseThrow();
    }

    @Transactional
    public Integer getTotalMinuteUserPlayList(Long id) {
        return userRepository.findById(id)
                .map(UserView::new)
                .stream()
                .flatMap(userView -> userView.getSongs().stream())
                .map(SongView::getDuration)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
