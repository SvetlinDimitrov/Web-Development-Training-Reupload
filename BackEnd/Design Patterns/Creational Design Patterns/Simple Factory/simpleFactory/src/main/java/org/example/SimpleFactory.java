package org.example;

import org.example.animals.*;

public class SimpleFactory {
    public static Animals getAnimal(String name) throws AnimalNotExitException {
        return switch (name) {
            case "dog" -> new Dog();
            case "cat" -> new Cat();
            case "eagle" -> new Eagle();
            case "frog" -> new Frog();
            default -> throw new AnimalNotExitException();
        };
    }
}
