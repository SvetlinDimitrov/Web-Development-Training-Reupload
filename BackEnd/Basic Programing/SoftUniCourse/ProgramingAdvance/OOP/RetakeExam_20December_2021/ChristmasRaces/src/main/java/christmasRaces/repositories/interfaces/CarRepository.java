package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;

import java.util.*;

public class CarRepository implements Repository<Car>{
    private HashMap<String , Car> models;

    public CarRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {

        return models.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Car model) {
        models.putIfAbsent(model.getModel() , model);
    }

    @Override
    public boolean remove(Car model) {
        Car car = models.remove(model.getModel());
        if(car == null){
            return false;
        }
        return true;
    }
}
