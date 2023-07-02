package org.example;

import java.time.LocalDate;

public class Unit {
    private String name;
    private LocalDate dateOfCreation;
    private Integer age;
    private FlyWeigh flyWeigh;

    public Unit(String name,Integer age, FlyWeigh flyWeigh) {
        this.name = name;
        this.dateOfCreation = LocalDate.now();
        this.age = age;
        this.flyWeigh = flyWeigh;
    }

}
