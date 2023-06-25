package org.example.builderfactory;

import org.example.entity.Animal;
import org.example.entity.Frog;

public class FrogCreator extends AnimalFactory{
    @Override
    protected Animal createAnimal() {
        return new Frog();
    }
}
