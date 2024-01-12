package JavaAdvance.Exercises_Defining_Classes.Pokemon_Trainer_06;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges =0 ;

    private ArrayList<Pokemon>collection;

    public Trainer(String name) {
        this.name = name;
        this.collection = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon){
        collection.add(pokemon);
    }

    public void setBadges(int count) {
        this.badges += count;
    }

    public void loseHpAllPokemon(){

    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public ArrayList<Pokemon> getCollection() {
        return collection;
    }
}
