package com.example.mobileleweb.service.security;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.UserEntity;
import com.example.mobileleweb.domain.entity.UserRole;
import com.example.mobileleweb.domain.viewDtos.SecurityViewUser;
import com.example.mobileleweb.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImpTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailsServiceImp userDetailsServiceImp;

    private static UserEntity userEntity;
    private static SecurityViewUser securityUserView;
    private static final String VALID_USERNAME = "valid";
    private static final String NOT_VALID_USERNAME = "notValid";

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

        securityUserView = new SecurityViewUser(userEntity.getUsername() ,
                userEntity.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + userEntity.getRole().getRole().name())))
                .setUsername(userEntity.getUsername())
                .setPassword(userEntity.getPassword())
                .setFirstName(userEntity.getFirstName())
                .setLastName(userEntity.getLastName())
                .setActive(userEntity.getIsActive())
                .setRole(userEntity.getRole().getRole())
                .setImageUrl(userEntity.getImageUrl())
                .setCreated(userEntity.getCreated())
                .setModified(userEntity.getModified());

    }

    @Test
    void loadUserByUsernameTest_MapCorrectlyTheUserEntity() {
        when(userRepository.findByUsername(VALID_USERNAME)).thenReturn(Optional.of(userEntity));

        UserDetails result = userDetailsServiceImp.loadUserByUsername(VALID_USERNAME);

        assertEquals(securityUserView , result);
    }

    @Test
    void loadUserByUsernameTest_ThrowsForNoExistingUsername() {
        when(userRepository.findByUsername(NOT_VALID_USERNAME)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userDetailsServiceImp.loadUserByUsername(NOT_VALID_USERNAME));
    }
}