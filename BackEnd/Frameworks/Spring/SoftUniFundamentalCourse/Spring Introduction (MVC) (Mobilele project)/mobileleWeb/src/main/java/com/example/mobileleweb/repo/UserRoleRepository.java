package com.example.mobileleweb.repo;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole , String> {
    Optional<UserRole> findByRole(Role role);
}
