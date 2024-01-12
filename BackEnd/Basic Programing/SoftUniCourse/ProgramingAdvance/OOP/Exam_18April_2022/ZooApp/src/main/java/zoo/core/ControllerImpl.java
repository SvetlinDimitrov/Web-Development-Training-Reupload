package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository = new FoodRepositoryImpl();
    private Collection<Area> areas = new ArrayList<>();

    @Override
    public String addArea(String areaType, String areaName) {
        Area area ;
        if(areaType.equals("WaterArea")){
            area = new WaterArea(areaName);
        }else if(areaType.equals("LandArea")){
            area = new LandArea(areaName);
        }else{
            throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.add(area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE,areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food ;
        if(foodType.equals("Vegetable")){
            food = new Vegetable();
        }else if(foodType.equals("Meat")){
            food = new Meat();
        }else{
            throw new NullPointerException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE,foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food foodToAdd = foodRepository.findByType(foodType);
        if(foodToAdd == null){
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND,foodType));
        }

        for (Area area : areas) {
            if(area.getName().equals(areaName)){
                area.addFood(foodToAdd);
                break;
            }
        }
        foodRepository.remove(foodToAdd);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA,foodType ,areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal ;
        if(animalType.equals("AquaticAnimal")){
            animal = new AquaticAnimal(animalName ,kind , price);
        }else if (animalType.equals("TerrestrialAnimal")){
            animal = new TerrestrialAnimal(animalName ,kind , price);
        }else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        Area area = areas.stream().filter(e->e.getName().equals(areaName)).findFirst().orElse(null);
        if(animal.getClass().getSimpleName().equals("AquaticAnimal") && area.getClass().getSimpleName().equals("WaterArea") ||
                animal.getClass().getSimpleName().equals("TerrestrialAnimal") && area.getClass().getSimpleName().equals("LandArea")){
            area.addAnimal(animal);
        }else {
            return AREA_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA,animalType , areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = areas.stream().filter(e->e.getName().equals(areaName)).findFirst().orElse(null);
        area.getAnimals().forEach(Animal::eat);
        return String.format(ANIMALS_FED,area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = areas.stream().filter(e->e.getName().equals(areaName)).findFirst().orElse(null);

        return String.format(KILOGRAMS_AREA,areaName , area.getAnimals().stream().mapToDouble(Animal::getKg).sum());
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        areas.forEach(e->builder.append(String.format("%s%n",e.getInfo())));
        return builder.toString().trim();
    }
}
