package com.example.spring_mapper_exercise;

import com.example.spring_mapper_exercise.domain.DTOs.GameAddDto;
import com.example.spring_mapper_exercise.domain.DTOs.UserLoginDto;
import com.example.spring_mapper_exercise.domain.DTOs.UserRegisterDto;
import com.example.spring_mapper_exercise.service.GameService;
import com.example.spring_mapper_exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Controller implements CommandLineRunner {
    private UserService userService;
    private GameService gameService;
    private Scanner scanner;

    @Autowired
    public Controller(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        String input = scanner.nextLine();
        while(!input.equals("close")){
            String [] commands = input.split("\\|");
            switch (commands[0]) {

                case "RegisterUser" -> {
                    try{
                        UserRegisterDto userRegisterDto = new UserRegisterDto(commands[1], commands[2], commands[3], commands[4]);
                        userService.RegisterUser(userRegisterDto);
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }

                case "LoginUser" -> {
                    UserLoginDto userLoginDto = new UserLoginDto(commands[1], commands[2]);
                    userService.LoginUser(userLoginDto);
                }

                case "Logout" -> userService.Logout();

                case "AddGame" -> {
                    try{
                        GameAddDto gameAddDto = new GameAddDto(commands[1] , commands[2] ,commands[3] , commands[4],commands[5],commands[6] , commands[7]);
                        gameService.AddGame(gameAddDto);
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }

                case "EditGame" -> gameService.EditGame(commands);


                case "DeleteGame" -> gameService.DeleteGame(commands[1]);

                case "AllGames" -> gameService.AllGames();

                case "DetailGame" -> gameService.DetailGame();

                case "OwnedGames" -> userService.OwnedGames();
                case "AddItem" -> userService.AddItem(commands[1]);
                case "RemoveItem" -> userService.RemoveItem(commands[1]);
                case "BuyItem" -> userService.BuyItem();
            }
            input=scanner.nextLine();
        }
    }
}
