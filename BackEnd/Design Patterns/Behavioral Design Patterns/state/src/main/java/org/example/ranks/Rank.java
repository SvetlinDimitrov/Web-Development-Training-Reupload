package org.example.ranks;

import org.example.Solder;

public abstract class Rank {
    protected final Solder solder;

    protected Rank(Solder solder) {
        this.solder = solder;
    }

    public abstract void updRank();
    public abstract void executeOperation();
    public abstract void createOperation();
}
