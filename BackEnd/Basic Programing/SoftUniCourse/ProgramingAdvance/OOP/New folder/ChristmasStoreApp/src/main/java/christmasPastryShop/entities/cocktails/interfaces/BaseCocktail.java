package christmasPastryShop.entities.cocktails.interfaces;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseCocktail implements Cocktail{
    private String name;
    private int size;
    private double price;
    private String brand;

    public void setBrand(String brand) {
        if(brand == null || brand.trim().length() == 0){
            throw new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }

    public void setPrice(double price) {
        if(price <=0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    public void setSize(int size) {
        if(size <= 0){
            throw new IllegalArgumentException(INVALID_SIZE);
        }
        this.size = size;
    }

    public void setName(String name) {
        if(name == null || name.trim().length() ==0){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    protected BaseCocktail(String name, int size, double price, String brand) {
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %dml - %.2flv",name,brand,size,price);
    }
}
