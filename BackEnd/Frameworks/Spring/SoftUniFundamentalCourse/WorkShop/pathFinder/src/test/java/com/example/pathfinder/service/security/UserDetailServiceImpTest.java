package com.example.pathfinder.service.security;

import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.entity.UserEntity;
import com.example.pathfinder.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserDetailServiceImpTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserDetailServiceImp userDetailServiceImp;

    private final static String VALID_USERNAME = "valid";


    @Test
    void loadUserByUsername() {
        when(userService.findByUsername(VALID_USERNAME)).thenReturn(mock(LoginUserDto.class));

        userDetailServiceImp.loadUserByUsername(VALID_USERNAME);

        verify(userService).findByUsername(VALID_USERNAME);
    }
}