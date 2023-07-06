package org.example.ranks;

import org.example.Solder;

public class Sergeant extends Rank {
    public Sergeant(Solder solder) {
        super(solder);
    }

    @Override
    public void updRank() {
        solder.changeRank(new SergeantMajor(solder));
        System.out.println("Congrats!! "+ solder.getName() +" you just become the highest rank possible");
    }

    @Override
    public void executeOperation() {
        System.out.println("As an sergeant you tell your newbies solders what to do");
    }

    @Override
    public void createOperation() {
        System.out.println("You are carefully listening to the SergeantMajor and creating the operation");
    }
}
