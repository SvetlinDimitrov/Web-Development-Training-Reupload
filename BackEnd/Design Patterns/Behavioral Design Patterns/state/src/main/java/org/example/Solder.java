package org.example;

import org.example.ranks.Private;
import org.example.ranks.Rank;

public class Solder {
    private Rank rank;
    private final String name;


    public Solder(String name) {
        this.name = name;
        this.rank = new Private(this);
    }

    public String getName() {
        return name;
    }

    public void changeRank(Rank rank){
        this.rank = rank;
    }

    public void rankUp(){
        rank.updRank();
    }
    public void executeOperation(){
        rank.executeOperation();
    }

    public void createOperation(){
        rank.createOperation();
    }
}
