package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.*;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail>{
    private ArrayList<Cocktail> models;

    public CocktailRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        Cocktail cocktail = null;
        for (Cocktail model : models) {
            if(model.getName().equals(name)){
                cocktail = model;
            }
        }
        return cocktail;
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Cocktail cocktail) {
        models.add(cocktail);
    }
}
