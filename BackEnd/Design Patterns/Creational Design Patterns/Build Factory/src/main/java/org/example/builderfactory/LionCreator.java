package org.example.builderfactory;

import org.example.entity.Animal;
import org.example.entity.Lion;

public class LionCreator extends AnimalFactory {
    @Override
    protected Animal createAnimal() {
        return new Lion();
    }
}
