package com.example.spring_mapper_exercise.repository;

import com.example.spring_mapper_exercise.domain.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {
    Game findById (long id);

    Game findByTitle(String title);
}
