package org.example.ranks;

import org.example.Solder;

public class SergeantMajor extends Rank{
    public SergeantMajor(Solder solder) {
        super(solder);
    }

    @Override
    public void updRank() {
        System.out.println("This is the heights possible rank ever you cant go beyond that");
    }

    @Override
    public void executeOperation() {
        System.out.println("thanks to your commands the operation is done");
    }

    @Override
    public void createOperation() {
        System.out.println("you are carefully telling the new sergeant how to think and together creating the mission");
    }
}
