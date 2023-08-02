package com.example.democache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.*;

public class Zoo {
    private final Map<Integer, Animal> animalMap;
    private final String name;

    public Zoo(String name) {
        this.animalMap = new HashMap<>();
        this.name = name;
    }

    @Cacheable("animals")
    public Collection<Animal> getAnimalList() throws InterruptedException {
        Thread.sleep(5000);
        return animalMap.values();
    }

    public String getName() {
        return name;
    }


    public void addAnimal(Animal animal) {
        animalMap.put(animal.getId(), animal);
    }

    public void removeAnimal(Integer id) {
        animalMap.remove(id);
    }
}
