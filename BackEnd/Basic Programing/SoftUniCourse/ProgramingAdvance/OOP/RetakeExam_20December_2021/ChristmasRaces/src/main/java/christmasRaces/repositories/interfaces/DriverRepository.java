package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;

import java.util.*;

public class DriverRepository implements Repository<Driver>{

    private HashMap<String,Driver> models;

    public DriverRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {

        return models.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Driver model) {
        models.putIfAbsent(model.getName() , model);
    }

    @Override
    public boolean remove(Driver model) {
        Driver driver = models.remove(model.getName());
        if(driver == null){
            return false;
        }
        return true;
    }
}