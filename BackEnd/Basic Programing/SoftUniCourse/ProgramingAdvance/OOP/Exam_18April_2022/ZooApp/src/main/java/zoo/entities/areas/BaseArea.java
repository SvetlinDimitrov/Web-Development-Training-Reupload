package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseArea implements Area{
    private String name;
    private int capacity;
    private Collection<Food>foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        foods= new ArrayList<>();
        animals = new ArrayList<>();
    }

    public void setName(String name) {
        if(name == null || name.trim().length()==0){
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        return foods.stream()
                .mapToInt(Food::getCalories)
                .sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if(animals.size() -1 >= capacity){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {

        String print = String.format("%s (%s):%n", name, getClass().getSimpleName()) +
                String.format("Animals: %s%n",
                        animals.size() == 0 ? "none" : animals.stream().map(Animal::getName).collect(Collectors.joining(" "))) +
                String.format("Foods: %d%n", foods.size()) +
                String.format("Calories: %d", sumCalories());

        return print.trim();

    }
}
