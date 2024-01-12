package com.example.spring_mapper_exercise.service;

import com.example.spring_mapper_exercise.domain.DTOs.OrderDto;
import com.example.spring_mapper_exercise.domain.DTOs.UserLoginDto;
import com.example.spring_mapper_exercise.domain.DTOs.UserRegisterDto;
import com.example.spring_mapper_exercise.domain.entities.*;
import com.example.spring_mapper_exercise.repository.GameRepo;
import com.example.spring_mapper_exercise.repository.OrderRepo;
import com.example.spring_mapper_exercise.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.spring_mapper_exercise.domain.enums.CONSTANTS.*;
import static com.example.spring_mapper_exercise.domain.enums.UNITS.MODEL_MAPPER;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    private GameRepo gameRepo;
    private OrderRepo orderRepo;
    private User user;
    private Order order;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, GameRepo gameRepo, OrderRepo orderRepo) {
        this.userRepo = userRepo;
        this.gameRepo = gameRepo;
        this.orderRepo = orderRepo;

    }

    @Override
    public void RegisterUser(UserRegisterDto userRegisterDto) {
        ModelMapper mapper = new ModelMapper();

        User user = mapper.map(userRegisterDto, User.class);
        if(userRepo.findAll().size() == 0){
            user.setIsAdmit(true);
        }

        if(userRepo.findByEmail(user.getEmail()) != null){
            System.out.printf(UNSUCCESSFUL_REG , user.getFullName());
            return;
        }

        userRepo.save(user);

        System.out.printf((SUCCESSFUL_REG) + "%n",userRegisterDto.getFullName());
    }

    @Override
    public void LoginUser(UserLoginDto userLoginDto) {
        if(order != null){
            order = null;
        }
        this.user = userRepo.findByEmail(userLoginDto.getEmail());

        if(user != null && user.getPassword().equals(userLoginDto.getPassword())){
            System.out.printf((SUCCESSFUL_LOGIN_IN) + "%n", user.getFullName());
            return;
        }
        user = null;
        System.out.println(PASSWORD_NAME_WRONG);
    }

    @Override
    public void Logout() {
        if(user != null){
            String userName = user.getFullName();
            user = null;
            System.out.printf((SUCCESSFUL_LOGOUT) + "%n", userName);
            return;
        }
        System.out.println(FAILED_LOGOUT);
    }

    @Override
    public void OwnedGames() {
        if(user == null){
            System.out.println(FAILED_TO_VIEW_ALL_GAMES_FOR_THE_USER);
            return;
        }
        user.getGames()
                .forEach(g-> System.out.println(g.getTitle()));
    }

    @Override
    @Transactional
    public void AddItem(String titleGame) {
        if (checkIfUserIsLogged()) return;

        checkIfShoppingCarIsEmpty();
        Game game = gameRepo.findByTitle(titleGame);

        if (checkIfTheGameExists(titleGame, game)) return;

        boolean userContainingTheGame = user.getGames().stream()
                .map(Game::getTitle)
                .anyMatch(e -> e.equals(titleGame));

        if (checkIfTheGameWasBoughtBefore(userContainingTheGame)) return;

        boolean gameIsAlreadyInTheOrder = order.getGameList().stream()
                .map(Game::getTitle)
                .anyMatch(e -> e.equals(titleGame));

        if (checkIfTheGameIsAlreadyOrdered(gameIsAlreadyInTheOrder)) return;

        order.getGameList().add(game);
        System.out.println(GAME_WAS_SUCCESSFULLY_ADDED);

    }


    @Override
    public void RemoveItem(String titleGame) {
        if (checkIfUserIsLogged()) return;

        if (checkIfTheShoppingCardIsEmpty()) return;

        boolean match = order.getGameList().stream()
                .map(Game::getTitle)
                .anyMatch(e -> e.equals(titleGame));

        if(!match){
            System.out.println(REMOVE_ITEM_FAILED);
            return;
        }

        order.getGameList()
                .removeIf(e->e.getTitle().equals(titleGame));

        System.out.printf(REMOVE_ITEM_SUCCESSES,titleGame);
    }


    @Override
    @Transactional
    public void BuyItem() {
        if (checkIfUserIsLogged()) return;

        if (checkIfTheShoppingCardIsEmpty()) return;

        order.setUser(user);
        orderRepo.saveAndFlush(order);

        user.getGames().addAll(order.getGameList());
        userRepo.saveAndFlush(user);

        order = new Order();
        System.out.println(ORDER_SUCCESSES);
    }

    private static boolean checkIfTheGameIsAlreadyOrdered(boolean gameIsAlreadyInTheOrder) {
        if(gameIsAlreadyInTheOrder){
            System.out.println(GAME_WAS_ALREADY_ADDED);
            return true;
        }
        return false;
    }

    private static boolean checkIfTheGameWasBoughtBefore(boolean userContainingTheGame) {
        if(userContainingTheGame){
            System.out.printf(GAME_WAS_BOUGHT_BEFORE);
            return true;
        }
        return false;
    }

    private static boolean checkIfTheGameExists(String titleGame, Game game) {
        if(game == null){
            System.out.printf(GAME_DOES_NOT_EXIST, titleGame);
            return true;
        }
        return false;
    }

    private void checkIfShoppingCarIsEmpty() {
        if(order == null){
            order = new Order();
        }
    }

    private boolean checkIfUserIsLogged() {
        if(user == null){
            System.out.println(LOGIN_FIRST);
            return true;
        }
        return false;
    }
    private boolean checkIfTheShoppingCardIsEmpty() {
        if(order.getGameList().isEmpty()){
            System.out.println(EMPTY_SHOPPING_CARD);
            return true;
        }
        return false;
    }
}