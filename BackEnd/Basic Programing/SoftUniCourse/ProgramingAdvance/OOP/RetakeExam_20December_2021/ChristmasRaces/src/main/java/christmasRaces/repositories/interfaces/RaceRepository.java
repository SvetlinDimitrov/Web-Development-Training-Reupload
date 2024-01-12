package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.races.Race;

import java.util.*;

public class RaceRepository implements Repository<Race>{
    private HashMap<String , Race> models;

    public RaceRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {

        return models.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Race model) {
        models.putIfAbsent(model.getName() , model);
    }

    @Override
    public boolean remove(Race model) {
        Race racees = models.remove(model.getName());
        return racees != null;
    }
}