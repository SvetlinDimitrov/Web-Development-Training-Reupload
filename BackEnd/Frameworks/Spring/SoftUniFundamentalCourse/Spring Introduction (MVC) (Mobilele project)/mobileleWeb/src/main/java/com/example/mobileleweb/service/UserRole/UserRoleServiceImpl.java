package com.example.mobileleweb.service.UserRole;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.UserRole;
import com.example.mobileleweb.repo.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole findByRole(Role role) {
        return userRoleRepository.findByRole(role).orElseThrow(NoSuchElementException::new);
    }

    @PostConstruct
    public void fillData() {
        Role[] values = Role.values();
        if (userRoleRepository.count() < values.length - 1) {
            Arrays.stream(values).map(UserRole::new)
                    .forEach(u -> {
                        if (userRoleRepository.findByRole(u.role).isEmpty()) {
                            userRoleRepository.save(u);
                        }
                    });
        }
    }
}
