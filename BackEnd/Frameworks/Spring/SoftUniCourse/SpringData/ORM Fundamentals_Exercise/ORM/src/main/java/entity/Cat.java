package entity;

import anotationTest.Column;
import anotationTest.Entity;
import anotationTest.Id;

@Entity(name = "cats")
public class Cat {
    @Id(name = "id")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name ;
    @Column(name = "email")
    private String email ;
    @Column(name = "something")
    private String something ;
    @Column(name = "age")
    private int age ;

    @Column(name = "nails")
    private int nails;

    @Column(name = "heads")
    private int heads;

    @Column(name = "power")
    private String power = "doNothing";

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    public int getId() {
        return id;
    }

    public Cat setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Cat setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPower() {
        return power;
    }

    public Cat setPower(String power) {
        this.power = power;
        return this;
    }
}
