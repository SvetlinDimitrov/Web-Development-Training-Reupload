package org.example;

public class Car extends Vehicle{
    private final static Integer speed = 50;

    public Car() {
    }

    @Override
    protected void reset(Vehicle vehicle) {
        vehicle.setSpeed(speed);
    }

}
