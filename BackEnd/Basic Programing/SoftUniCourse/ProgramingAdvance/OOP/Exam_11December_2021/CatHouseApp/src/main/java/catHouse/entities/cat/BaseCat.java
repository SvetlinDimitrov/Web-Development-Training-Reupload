package catHouse.entities.cat;

import static catHouse.common.ExceptionMessages.*;

public abstract class BaseCat implements Cat{
    private String name;
    private String breed;
    private int kilograms;
    private double price;

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    public String getBreed() {
        return breed;
    }

    protected BaseCat(String name, String breed, double price) {
        setName(name);
        setBreed(breed);
        setPrice(price);
    }

    public void setPrice(double price) {
        if(price <=0){
            throw new IllegalArgumentException(CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    public void setBreed(String breed) {
        if(null == breed || breed.trim().length() == 0){
            throw new NullPointerException(CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.breed = breed;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(null == name || name.trim().length()==0){
            throw new NullPointerException(CAT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getKilograms() {
        return kilograms;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
