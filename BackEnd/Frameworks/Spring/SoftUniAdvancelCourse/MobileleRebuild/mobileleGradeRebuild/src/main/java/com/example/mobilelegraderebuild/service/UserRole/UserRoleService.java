package com.example.mobilelegraderebuild.service.UserRole;

import com.example.mobilelegraderebuild.domain.constants.Role;
import com.example.mobilelegraderebuild.domain.entity.UserRole;

public interface UserRoleService {
    UserRole findByRole(Role role);
}
