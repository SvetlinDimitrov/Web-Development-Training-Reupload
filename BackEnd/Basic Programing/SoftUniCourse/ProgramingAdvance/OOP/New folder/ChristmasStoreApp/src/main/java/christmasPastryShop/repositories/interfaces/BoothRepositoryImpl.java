package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.*;
import java.util.List;

public class BoothRepositoryImpl implements BoothRepository<Booth>{
    private List<Booth> models;

    public BoothRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        Booth booth = null;
        for (Booth model : models) {
            if(model.getBoothNumber() == number){
                booth = model;
            }
        }
        return booth;
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Booth booth) {
        models.add(booth);
    }
}
