package com.example.pathfinder.service.role;

import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.Role;
import com.example.pathfinder.repos.RoleRepository;
import com.example.pathfinder.repos.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Override
    public Set<Role> getRegisterRoles() {
        Set<Role> roles = new HashSet<>();

        roles.add(roleRepository
                .findByRole(RoleConstant.USER)
                .orElseThrow(() -> new RuntimeException("user role does not existed")));

        if (userRepository.count() == 0) {
            roles.add(roleRepository
                    .findByRole(RoleConstant.ADMIN)
                    .orElseThrow(() -> new RuntimeException("admin role does not existed")));
        }
        return roles;
    }
}
