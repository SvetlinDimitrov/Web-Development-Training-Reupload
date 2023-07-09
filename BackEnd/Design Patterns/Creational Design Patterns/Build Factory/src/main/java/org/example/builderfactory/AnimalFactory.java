package org.example.builderfactory;

import org.example.entity.Animal;

public abstract class AnimalFactory {

    public Animal getAnimal(){
        Animal animal = createAnimal();
        animal.showPower();
        return animal;
    }

    protected abstract Animal createAnimal();
}
