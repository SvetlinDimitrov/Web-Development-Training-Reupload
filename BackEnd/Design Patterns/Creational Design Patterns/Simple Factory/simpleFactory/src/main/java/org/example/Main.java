package org.example;

public class Main {
    public static void main(String[] args) throws AnimalNotExitException {
        System.out.println(SimpleFactory.getAnimal("dog"));
    }
}