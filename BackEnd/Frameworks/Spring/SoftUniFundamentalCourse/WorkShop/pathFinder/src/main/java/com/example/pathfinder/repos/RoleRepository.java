package com.example.pathfinder.repos;

import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role , Long> {
    Optional<Role> findByRole(RoleConstant role);
}
