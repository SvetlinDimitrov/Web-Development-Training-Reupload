package com.example.pathfinder.service.user;

import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.domain.entity.UserEntity;
import com.example.pathfinder.repos.UserRepository;
import com.example.pathfinder.service.role.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleService roleService;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    private static RegisterUserDto registerUserDto;
    private static UserEntity userEntity;
    private static ViewUser viewUser;
    private static LoginUserDto loginUserDto;
    private final static String PRESENT_EMAIL = "present@abv.bg";
    private final static String NOT_PRESENT_EMAIL = "notPresent@abv.bg";
    private final static String NOT_PRESENT_USERNAME = "notPresent";
    private final static String PRESENT_USERNAME = "present";
    private final static Long VALID_ID = 1L;
    private final static Long NOT_VALID_ID = 99L;

    @BeforeEach
    void setUp() {
        registerUserDto = new RegisterUserDto(
                "test",
                "test testov",
                17,
                "12345",
                "test@abv.bg",
                "12345");

        userEntity = UserEntity.builder()
                .username("test")
                .fullName("test testov")
                .age(17)
                .password("secret")
                .email("test@abv.bg")
                .level(Level.BEGINNER)
                .roles(Set.of())
                .route(List.of())
                .pictures(List.of())
                .messages(List.of())
                .build();
        userEntity.setId(1L);

        viewUser = ViewUser.builder()
                .username("test")
                .fullName("test testov")
                .age(17)
                .email("test@abv.bg")
                .level(Level.BEGINNER)
                .roles(Set.of())
                .route(List.of())
                .pictures(List.of())
                .messages(List.of())
                .build();
        viewUser.setId(1L);

        loginUserDto = new LoginUserDto(
                userEntity.getUsername(),
                userEntity.getPassword(),
                Set.of(),
                userEntity.getId());


    }

    @Test
    void registerTest_successful() {
//        when(passwordEncoder.encode("12345")).thenReturn("secret");
//        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
//
//        userService.register(registerUserDto);
//
//        ArgumentCaptor<UserEntity> userEntityCaptor = ArgumentCaptor.forClass(UserEntity.class);
//        verify(userRepository).save(userEntityCaptor.capture());
//
//        UserEntity result = userEntityCaptor.getValue();
//
//        assertEquals(userEntity, result);

    }

    @Test
    void checkTheEmailTest_EmailNotPresent() {

        when(userRepository.findByEmail(PRESENT_EMAIL)).thenReturn(Optional.empty());

        assertTrue(userService.checkTheEmail(PRESENT_EMAIL));
    }

    @Test
    void checkTheEmailTest_EmailPresent() {

        when(userRepository.findByEmail(NOT_PRESENT_EMAIL)).thenReturn(Optional.empty());

        assertTrue(userService.checkTheEmail(NOT_PRESENT_EMAIL));
    }

    @Test
    void availableUsernameTest_UsernamePresent() {
        when(userRepository.findByUsername(PRESENT_USERNAME)).thenReturn(Optional.of(mock(UserEntity.class)));

        assertFalse(userService.avalibaleUsername(PRESENT_USERNAME));
    }

    @Test
    void availableUsernameTest_UsernameNotPresent() {
        when(userRepository.findByUsername(NOT_PRESENT_USERNAME)).thenReturn(Optional.empty());

        assertTrue(userService.avalibaleUsername(NOT_PRESENT_USERNAME));
    }

    @Test
    void getViewUserByIdTest_withValidId() {
        userEntity.setId(VALID_ID);
        viewUser.setId(VALID_ID);

        when(userRepository.findById(VALID_ID)).thenReturn(Optional.ofNullable(userEntity));

        ViewUser result = userService.getViewUserById(VALID_ID);

        assertEquals(viewUser , result);

    }

    @Test
    void getViewUserByIdTest_withNotValidId() {

        when(userRepository.findById(NOT_VALID_ID)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class ,
                () ->userService.getViewUserById(NOT_VALID_ID));

    }


    @Test
    void findByUsernameTest_withValidUsername() {
        when(userRepository.findByUsername(PRESENT_USERNAME)).thenReturn(Optional.of(userEntity));

        LoginUserDto result = userService.findByUsername(PRESENT_USERNAME);

        assertEquals(loginUserDto , result);

    }

    @Test
    void findByUsernameTest_withNotValidUsername() {
        when(userRepository.findByUsername(NOT_PRESENT_USERNAME)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class ,() -> userService.findByUsername(NOT_PRESENT_USERNAME));

    }

}