package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseBooth implements Booth{
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price ;

    protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    public void setCapacity(int capacity) {
        if(capacity < 0){
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
        price = this.numberOfPeople * pricePerPerson;
    }

    @Override
    public double getBill() {
        double coctails = cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        double delicates = delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        return coctails+delicates;
    }

    @Override
    public void clear() {
        cocktailOrders.clear();
        delicacyOrders.clear();
        price =0;
        numberOfPeople=0;
        isReserved = false;
    }
}
