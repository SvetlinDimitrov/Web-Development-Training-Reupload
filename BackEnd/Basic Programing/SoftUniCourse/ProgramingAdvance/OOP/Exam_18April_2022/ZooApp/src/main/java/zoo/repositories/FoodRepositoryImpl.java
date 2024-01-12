package zoo.repositories;

import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository{

    private Collection<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        return foods.remove(food);
    }

    @Override
    public Food findByType(String type) {

        return foods.stream()
                .filter(e->e.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
