package com.example.spring_mapper_exercise.service;

import com.example.spring_mapper_exercise.domain.DTOs.GameAddDto;

public interface GameService {
    void AddGame(GameAddDto gameAddDto);

    void EditGame(String[] arr);

    void DeleteGame(String input);

    void AllGames();

    void DetailGame();
}
