package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.ArrayList;
import java.util.Collection;

public class PresentRepository implements Repository<Present>{
    private Collection<Present> presents ;

    public PresentRepository() {
        this.presents = new ArrayList<>();
    }

    @Override
    public Collection<Present> getModels() {
        return presents;
    }

    @Override
    public void add(Present model) {
        presents.add(model);
    }

    @Override
    public boolean remove(Present model) {
        return presents.remove(model);
    }

    @Override
    public Present findByName(String name) {

        return presents.stream()
                .filter(e->e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
