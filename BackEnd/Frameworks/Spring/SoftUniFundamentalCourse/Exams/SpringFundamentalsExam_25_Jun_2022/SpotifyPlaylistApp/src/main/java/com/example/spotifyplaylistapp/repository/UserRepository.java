package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Long> {
    Optional<UserEntity> findByUsername (String username);

    Optional<UserEntity> findByEmail(String email);
}

