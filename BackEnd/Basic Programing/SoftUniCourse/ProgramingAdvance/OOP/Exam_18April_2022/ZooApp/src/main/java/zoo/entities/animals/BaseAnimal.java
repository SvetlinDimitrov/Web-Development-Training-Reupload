package zoo.entities.animals;

import static zoo.common.ExceptionMessages.*;


public abstract class BaseAnimal implements Animal {
    private String name;
    private String kind;
    private double kg;
    private double price;

    protected BaseAnimal(String name, String kind, double kg, double price) {
        setName(name);
        setKind(kind);
        this.kg = kg;
        setPrice(price);
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public void setName(String name) {
        if(name == null || name.trim().length() ==0){
            throw new NullPointerException(ANIMAL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setKind(String kind) {
        if(kind ==null || kind.trim().length() ==0){
            throw new NullPointerException(ANIMAL_KIND_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    public void setPrice(double price) {
        if(price <=0){
            throw new IllegalArgumentException(ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getKg() {
        return kg;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
