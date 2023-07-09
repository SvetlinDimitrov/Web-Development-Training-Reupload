package org.example;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle vehicle = new Car();
        vehicle.setEngine("kasko");
        Vehicle clone = vehicle.clone();
        System.out.println("Hello world!");
    }
}