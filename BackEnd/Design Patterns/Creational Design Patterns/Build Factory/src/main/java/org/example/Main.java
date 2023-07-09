package org.example;

import org.example.builderfactory.AnimalFactory;
import org.example.builderfactory.FrogCreator;
import org.example.builderfactory.LionCreator;
import org.example.entity.Animal;

public class Main {
    public static void main(String[] args) {
        AnimalFactory animalLionFactory = new LionCreator();
        Animal lion = animalLionFactory.getAnimal();

        AnimalFactory animalFrogFactory = new FrogCreator();
        Animal frog = animalFrogFactory.getAnimal();
    }
}