package org.example.ranks;

import org.example.Solder;

public class Private extends Rank{
    public Private(Solder solder) {
        super(solder);
    }

    @Override
    public void updRank() {
        this.solder.changeRank(new Sergeant(solder));
        System.out.println("Congrats!!You just become and Sergeant");
    }

    @Override
    public void executeOperation() {
        System.out.println("As a newbie you start impressing everyone by your passion and power");
    }

    @Override
    public void createOperation() {
        System.out.println("Your rank is to small to create an Operation you must be at least Sergeant");
    }
}
