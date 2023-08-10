package com.example.mobilelegraderebuild.service.UserRole;

import com.example.mobilelegraderebuild.domain.constants.Role;
import com.example.mobilelegraderebuild.domain.entity.UserRole;
import com.example.mobilelegraderebuild.repo.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole findByRole(Role role) {
        return userRoleRepository.findByRole(role).orElseThrow(NoSuchElementException::new);
    }

}
