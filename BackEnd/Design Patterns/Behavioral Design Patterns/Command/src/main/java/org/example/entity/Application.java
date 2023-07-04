package org.example.entity;

public abstract class Application {
    private Boolean isWorking;

    protected Application() {}

    public void turnOn(){
        isWorking = true;
        System.out.println("I am on");
    }

    public void turnOff(){
        isWorking = false;
        System.out.println("I am off");
    }

}
