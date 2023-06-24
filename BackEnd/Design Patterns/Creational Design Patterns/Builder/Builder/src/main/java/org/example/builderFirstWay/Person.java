package org.example.builderFirstWay;

import java.time.LocalDate;
import java.util.Stack;

public class Person {
    private String name;
    private Integer age;
    private String address;
    private LocalDate birthday;
    private Car car;

    private Person (){}

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Car getCar() {
        return car;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    private void setCar(Car car) {
        this.car = car;
    }

    public static BuilderPerson startToBuild(){
        return new BuilderPerson();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", car=" + car +
                '}';
    }

    public static class BuilderPerson{
        private  String name;
        private  Integer age;
        private  String address;
        private  LocalDate birthday;
        private  Car car;
        private  Person person;

        public  BuilderPerson setName(String name){
            this.name = name;
            return this;
        }

        public BuilderPerson setCar(Car car){
            this.car = car;
            return this;
        }
        public BuilderPerson setAge(Integer age){
            this.age = age;
            return this;
        }
        public BuilderPerson setAddress(String address){
            this.address = address;
            return this;
        }
        public BuilderPerson setBirthday(LocalDate birthday){
            this.birthday = birthday;
            return this;
        }

        public Person build(){
            person = new Person();
            person.setName(this.name);
            person.setCar(this.car);
            person.setAge(this.age);
            person.setAddress(this.address);
            person.setBirthday(this.birthday);
            return person;
        }

        public Person getPerson(){
            return person;
        }

    }
}
