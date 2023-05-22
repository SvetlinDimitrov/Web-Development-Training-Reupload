package com.example.spring_mapper_exercise.domain.enums;

public class CONSTANTS {
    ;
    public static final String EMAIL_VALIDATOR_REGEX = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    public static final String EMAIL_WRONG_MESSAGE = "Incorrect email.";
    public static final String PASSWORD_VALIDATOR_REGEX ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    public static final String PASSWORD_NAME_WRONG ="Incorrect username / password";
    public static final String SUCCESSFUL_REG ="%s was registered";
    public static final String LOGIN_FIRST ="you should login first";
    public static final String UNSUCCESSFUL_REG ="%s was already registered%n";
    public static final String SUCCESSFUL_LOGIN_IN ="Successfully logged in %s";
    public static final String FAILED_LOGOUT ="Cannot log out. No user was logged in.";
    public static final String SUCCESSFUL_LOGOUT ="User %s successfully logged out";
    public static final String GAME_CREATION_WRONG_TITLE ="Your title is fucked , try new one";
    public static final String GAME_CREATION_WRONG_PRICE ="Your price is can`t be negative";
    public static final String GAME_CREATION_WRONG_SIZE ="Your size is can`t be negative";
    public static final String GAME_CREATION_WRONG_TRAILER ="Your size for your trailer , should be 11 characters long";
    public static final String GAME_CREATION_WRONG_URL ="Your url is not starting properly";
    public static final String GAME_CREATION_WRONG_DESCRIPTION ="Your description is not long enough";
    public static final String GAME_CREATION_SUCCESSFUL ="Added %s";
    public static final String GAME_NOT_FOUND ="Game was not found";
    public static final String GAME_WAS_EDITED ="Edited %s%n";
    public static final String GAME_WAS_DELETED ="Deleted %s%n";

    public static final String SIMPLE_GAME_REVIEW = "%s %s%n";
    public static final String DETAILED_GAME_REVIEW = "Title: %s%n" +
            "Price: %s%n" +
            "Description: %s%n" +
            "Release date: %s%n";
    public static final String FAILED_TO_VIEW_ALL_GAMES_FOR_THE_USER = "You must be logged to view your games";
    public static final String GAME_DOES_NOT_EXIST = "%s those not exist%n";
    public static final String GAME_WAS_BOUGHT_BEFORE = "you already bought that game";
    public static final String GAME_WAS_ALREADY_ADDED = "you already added that game in the shopping card";
    public static final String GAME_WAS_SUCCESSFULLY_ADDED = "add game to shopping cart";
    public static final String EMPTY_SHOPPING_CARD = "your shopping card is empty";
    public static final String REMOVE_ITEM_FAILED = "you dont have that game in your shopping card";
    public static final String REMOVE_ITEM_SUCCESSES = "you successfuly removed %s%n";
    public static final String ORDER_SUCCESSES = "you successfuly made your order";




}
