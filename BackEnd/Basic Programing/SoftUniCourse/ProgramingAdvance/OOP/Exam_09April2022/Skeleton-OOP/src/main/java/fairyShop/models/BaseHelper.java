package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;

import static fairyShop.common.ExceptionMessages.*;

public abstract class BaseHelper implements Helper{
    private String name;
    private int energy;
    private Collection<Instrument>instruments;

    protected BaseHelper(String name, int energy) {
        setName(name);
        this.energy = energy;
        instruments = new ArrayList<>();
    }

    public void setName(String name) {
        if(name != null && name.trim().length() ==0){
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void work() {
        energy-=10;
        if(energy < 0){
            energy =0;
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return energy > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }
}
