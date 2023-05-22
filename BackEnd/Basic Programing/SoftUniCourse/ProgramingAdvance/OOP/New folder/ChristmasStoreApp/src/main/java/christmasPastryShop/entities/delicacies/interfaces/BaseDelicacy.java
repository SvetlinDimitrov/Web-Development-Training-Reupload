package christmasPastryShop.entities.delicacies.interfaces;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseDelicacy implements Delicacy{
    private String name;
    private double portion;
    private double price;

    protected BaseDelicacy(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    public void setPortion(double portion) {
        if(portion <= 0){
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setName(String name) {
        if(name == null || name.trim().length() == 0){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f",name,portion,price);
    }
}
