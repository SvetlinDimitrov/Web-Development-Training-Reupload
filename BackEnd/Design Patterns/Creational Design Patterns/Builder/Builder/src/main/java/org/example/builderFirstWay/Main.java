package org.example.builderFirstWay;

import org.example.builderFirstWay.Car;
import org.example.builderFirstWay.Person;

public class Main {
    public static void main(String[] args) {

        Person build = Person.startToBuild()
                .setName("Gosho")
                .setAge(15)
                .setCar(
                        Car.getBuilder()
                        .setDoors(3)
                        .setModel("BMW")
                        .setHorsePower(190)
                        .build()
                )
                .build();

        System.out.println(build);

    }
}