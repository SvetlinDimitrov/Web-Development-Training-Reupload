package com.example.mobileleweb.service.UserRole;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.UserRole;
import com.example.mobileleweb.repo.UserRoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserRoleServiceImplTest {

    @Mock
    private UserRoleRepository userRoleRepository;

    @InjectMocks
    private UserRoleServiceImpl userRoleService;

    private final static Role EXISTING_ROLE = Role.USER;
    private final static Role NOT_EXISTING_ROLE = null;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByRoleTest_shouldReturnUserRoleEntityForCorrectId() {
        when(userRoleRepository.findByRole(EXISTING_ROLE)).thenReturn(Optional.of(mock(UserRole.class)));

        UserRole result = userRoleService.findByRole(EXISTING_ROLE);

        assertNotNull(result);
    }

    @Test
    void findByRoleTest_shouldThrowForNotExistingRole() {
        when(userRoleRepository.findByRole(NOT_EXISTING_ROLE)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class , () -> userRoleService.findByRole(NOT_EXISTING_ROLE));
    }
}