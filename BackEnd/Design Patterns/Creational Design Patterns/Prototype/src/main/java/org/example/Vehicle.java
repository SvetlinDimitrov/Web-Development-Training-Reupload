package org.example;

public abstract class Vehicle  implements Cloneable{
    private String brand = "cat";
    private Integer speed =12;
    private String engine = "bmw";
    private Integer horsePower = 120;

    public Vehicle() {}

    @Override
    public Vehicle clone() throws CloneNotSupportedException {
        Vehicle clone = (Vehicle) super.clone();
        reset(clone);
        return clone;
    }

    protected abstract void reset(Vehicle vehicle);

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }
}
