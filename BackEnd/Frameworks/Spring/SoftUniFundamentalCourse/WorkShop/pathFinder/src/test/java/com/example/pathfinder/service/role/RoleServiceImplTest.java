package com.example.pathfinder.service.role;

import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.Role;
import com.example.pathfinder.repos.RoleRepository;
import com.example.pathfinder.repos.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    @BeforeEach
    public void setUp(){
        when(roleRepository.findByRole(RoleConstant.USER)).thenReturn(Optional.of(mock(Role.class)));
    }

    @Test
    public void getRegisterRolesTest_giveOnlyTheUserRole(){

        when(userRepository.count()).thenReturn(2L);

        Set<Role> result = roleService.getRegisterRoles();

        assertEquals(1 , result.size());

    }

    @Test
    public void getRegisterRolesTest_giveBothTheUserAndAdminRole(){

        when(userRepository.count()).thenReturn(0L);
        when(roleRepository.findByRole(RoleConstant.ADMIN)).thenReturn(Optional.of(mock(Role.class)));

        Set<Role> result = roleService.getRegisterRoles();

        assertEquals(2 , result.size());

    }

}