package com.example.mobilelegraderebuild.service.User;

import com.example.mobilelegraderebuild.domain.constants.Role;
import com.example.mobilelegraderebuild.domain.entity.UserEntity;
import com.example.mobilelegraderebuild.domain.entity.UserRole;
import com.example.mobilelegraderebuild.domain.viewDtos.RegisterUserDto;
import com.example.mobilelegraderebuild.repo.UserRepository;
import com.example.mobilelegraderebuild.service.UserRole.UserRoleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserRoleService userRoleService;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private SecurityContextRepository securityContextRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private static UserEntity userEntity;

    private static RegisterUserDto registerUserDto;
    private static final String EXISTING_USERNAME = "test1";
    private static final String NOT_EXISTING_USERNAME = "test999";

    @Captor
    private ArgumentCaptor<UserEntity> userEntityCaptor;

    private static final String LEGIT_ID = "legit";
    private static final String NOT_LEGIT_ID = "NOTlEGIT";

    @BeforeEach
    void setUp() {
        UserRole userRole = new UserRole(Role.ADMIN);
        userEntity = new UserEntity()
                .setUsername("test")
                .setPassword("12345")
                .setFirstName("testName")
                .setLastName("testLastName")
                .setActive(false)
                .setRole(userRole)
                .setImageUrl("imageUrl")
                .setCreated(LocalDate.parse("2018-10-23"))
                .setModified(LocalDate.parse("2018-10-23"))
                .setOffers(List.of());
        userEntity.setId("1");

        registerUserDto = new RegisterUserDto()
                .setFirstName(userEntity.getFirstName())
                .setRole(userEntity.getRole().getRole())
                .setPassword("123")
                .setLastName(userEntity.getLastName())
                .setUsername(userEntity.getUsername());

    }

    @Test
    void register_validRegisterDto_SuccessfullyRegister() {
        when(passwordEncoder.encode(any())).thenReturn("12345");
        when(userRoleService.findByRole(any())).thenReturn(userEntity.getRole());

        userService.register(registerUserDto , mock(HttpServletRequest.class) , mock(HttpServletResponse.class));

        verify(userRepository , times(1)).save(userEntityCaptor.capture());

        UserEntity result = userEntityCaptor.getValue();

        assertEquals(userEntity.getRole() , result.getRole());
        assertEquals(userEntity.getUsername() , result.getUsername());
        assertEquals(userEntity.getFirstName() , result.getFirstName());
        assertEquals(userEntity.getLastName() , result.getLastName());
        assertEquals(userEntity.getPassword() , result.getPassword());

    }

    @Test
    void checkIfUsernameAlreadyExistsTest_shouldReturnFalseForAlreadyExcitingUser() {
        when(userRepository.findByUsername(EXISTING_USERNAME)).thenReturn(Optional.of(userEntity));

        boolean result = userService.checkIfUsernameAlreadyExists(EXISTING_USERNAME);

        assertFalse(result);
    }

    @Test
    void checkIfUsernameAlreadyExistsTest_shouldReturnTrueForNonExistingUser() {
        when(userRepository.findByUsername(NOT_EXISTING_USERNAME)).thenReturn(Optional.empty());

        boolean result = userService.checkIfUsernameAlreadyExists(NOT_EXISTING_USERNAME);

        assertTrue(result);
    }

    @Test
    void getUserByUsernameTest_returnsTheUserIfItExisted() {
        when(userRepository.findByUsername(EXISTING_USERNAME)).thenReturn(Optional.of(userEntity));

        UserEntity result = userService.getUserByUsername(EXISTING_USERNAME);

        assertNotNull(result);
    }

    @Test
    void getUserByUsernameTest_ThrowsIfNobodyIsHome() {
        when(userRepository.findByUsername(NOT_EXISTING_USERNAME)).thenReturn(Optional.empty());

        assertThrows(
                NoSuchElementException.class, () -> userService.getUserByUsername(NOT_EXISTING_USERNAME)
        );
    }

    @Test
    void findByIdTest_ReturnsUserEntityIfTheUserIdIsLegit() {
        when(userRepository.findById(LEGIT_ID)).thenReturn(Optional.of(userEntity));

        UserEntity result = userService.findById(LEGIT_ID);

        assertNotNull(result);
    }

    @Test
    void findByIdTest_ThrowsExceptionIfNoBodyIsHome() {
        when(userRepository.findById(NOT_LEGIT_ID)).thenReturn(Optional.empty());

        assertThrows(
                NoSuchElementException.class , () -> userService.findById(NOT_LEGIT_ID)
        );
    }
}