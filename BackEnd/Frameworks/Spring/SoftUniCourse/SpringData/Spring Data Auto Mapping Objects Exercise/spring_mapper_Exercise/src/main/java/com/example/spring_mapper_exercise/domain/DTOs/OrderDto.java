package com.example.spring_mapper_exercise.domain.DTOs;

import com.example.spring_mapper_exercise.domain.entities.Game;
import com.example.spring_mapper_exercise.domain.entities.User;


import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private User user;

    private List<Game> gameList;

    public OrderDto() {
        this.gameList = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
