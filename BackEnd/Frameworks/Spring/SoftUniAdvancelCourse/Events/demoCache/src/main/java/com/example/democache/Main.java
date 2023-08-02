package com.example.democache;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final Zoo zoo;

    public Main(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public void run(String... args) throws Exception {
        fillZoo(zoo);

        zoo.getAnimalList().forEach(a-> System.out.print(a.getId() + " "));
        System.out.println();

        zoo.addAnimal(new Animal(11));
        zoo.getAnimalList().forEach(a-> System.out.print(a.getId() + " "));
        System.out.println();

        zoo.removeAnimal(11);
        zoo.removeAnimal(10);
        zoo.removeAnimal(9);
        zoo.removeAnimal(8);
        zoo.getAnimalList().forEach(a-> System.out.print(a.getId() + " "));


    }

    private void fillZoo(Zoo zoo){
        for (int i = 1; i <= 10; i++) {
            Animal animal = new Animal(i);
            zoo.addAnimal(animal);
        }
    }
}
