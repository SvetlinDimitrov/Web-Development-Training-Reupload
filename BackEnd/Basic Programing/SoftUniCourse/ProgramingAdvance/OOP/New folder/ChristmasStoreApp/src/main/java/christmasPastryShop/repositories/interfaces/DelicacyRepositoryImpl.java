package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.*;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy>{
    private ArrayList<Delicacy> models;

    public DelicacyRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
        Delicacy delicacy = null;
        for (Delicacy model : models) {
            if(model.getName().equals(name)){
                delicacy = model;
            }
        }
        return delicacy;
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Delicacy delicacy) {
        models.add(delicacy);
    }
}
