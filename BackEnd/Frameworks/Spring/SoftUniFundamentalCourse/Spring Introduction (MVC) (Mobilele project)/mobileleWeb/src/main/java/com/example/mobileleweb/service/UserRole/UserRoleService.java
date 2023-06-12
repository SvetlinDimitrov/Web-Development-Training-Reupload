package com.example.mobileleweb.service.UserRole;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.UserRole;

public interface UserRoleService {
    UserRole findByRole(Role role);
}
