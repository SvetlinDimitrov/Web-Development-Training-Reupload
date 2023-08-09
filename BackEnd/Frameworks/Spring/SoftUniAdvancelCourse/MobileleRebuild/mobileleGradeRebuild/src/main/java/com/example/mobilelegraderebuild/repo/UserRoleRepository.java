package com.example.mobilelegraderebuild.repo;

import com.example.mobilelegraderebuild.domain.constants.Role;
import com.example.mobilelegraderebuild.domain.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole , String> {
    Optional<UserRole> findByRole(Role role);
}
