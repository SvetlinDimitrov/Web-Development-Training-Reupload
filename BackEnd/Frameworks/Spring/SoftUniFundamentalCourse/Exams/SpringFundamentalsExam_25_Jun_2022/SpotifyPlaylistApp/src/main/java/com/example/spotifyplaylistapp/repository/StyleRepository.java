package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.StyleConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<StyleEntity, Long> {
    Optional<StyleEntity> findByName(StyleConstant styleConstant);
}
