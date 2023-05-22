package com.example.spring_mapper_exercise.service;

import com.example.spring_mapper_exercise.domain.DTOs.GameAddDto;
import com.example.spring_mapper_exercise.domain.entities.Game;
import com.example.spring_mapper_exercise.repository.GameRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.spring_mapper_exercise.domain.enums.CONSTANTS.*;

@Service
public class GameServiceImpl implements GameService {
    private GameRepo gameRepo;

    @Autowired
    public GameServiceImpl(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    public void AddGame(GameAddDto gameAddDto) {
        ModelMapper mapper = new ModelMapper();
        Game game = mapper.map(gameAddDto, Game.class);

        gameRepo.save(game);
        System.out.printf((GAME_CREATION_SUCCESSFUL) + "%n", game.getTitle());
    }

    @Override
    public void EditGame(String [] arr) {
        try{
            long idToEdit = Long.parseLong(arr[1]);
            Game game = gameRepo.findById(idToEdit);

            if(game == null){
                System.out.println(GAME_NOT_FOUND);
                return;
            }
            GameAddDto gameAddDto = new GameAddDto();

            for (int i = 0; i < arr.length - 2; i++) {
                String[] editDetails = arr[2 + i].split("=");
                String fieldToEdit = editDetails[0];
                String valueToPut = editDetails[1];

                switch (fieldToEdit) {
                    case "title" -> {
                        gameAddDto.setTitle(valueToPut);
                        game.setTitle(gameAddDto.getTitle());
                    }
                    case "price" -> {
                        gameAddDto.setPrice(valueToPut);
                        game.setPrice(gameAddDto.getPrice());
                    }
                    case "size" -> {
                        gameAddDto.setSize(valueToPut);
                        game.setSize(gameAddDto.getSize());
                    }
                    case "trailer" -> {
                        gameAddDto.setTrailer(valueToPut);
                        game.setTrailer(gameAddDto.getTrailer());
                    }
                    case "thubnailURL" -> {
                        gameAddDto.setThumbnailURL(valueToPut);
                        game.setImageThumbnail(gameAddDto.getImageThumbnail());
                    }
                    case "description" -> {
                        gameAddDto.setDescription(valueToPut);
                        game.setDescription(gameAddDto.getDescription());
                    }
                    case "releaseDate" -> {
                        gameAddDto.setReleaseDate(valueToPut);
                        game.setReleaseDate(gameAddDto.getReleaseDate());
                    }
                }

            }

            gameRepo.save(game);
            System.out.printf(GAME_WAS_EDITED , game.getTitle());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void DeleteGame(String input) {
        long idToDelete = Long.parseLong(input);
        Game game = gameRepo.findById(idToDelete);
        if(game == null){
            System.out.println(GAME_NOT_FOUND);
            return;
        }

        String nameGame = game.getTitle();
        gameRepo.deleteById(idToDelete);
        System.out.printf(GAME_WAS_DELETED,nameGame);
    }

    @Override
    public void AllGames() {
        gameRepo.findAll()
                .forEach(g-> System.out.printf(SIMPLE_GAME_REVIEW,
                        g.getTitle(),g.getPrice()));
    }

    @Override
    public void DetailGame() {
        gameRepo.findAll()
                .forEach(g-> System.out.printf(DETAILED_GAME_REVIEW,
                        g.getTitle(),g.getPrice(),g.getDescription(),g.getReleaseDate().toString()));
    }



}
