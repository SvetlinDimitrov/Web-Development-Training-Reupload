package org.example;

public class Main {
    public static void main(String[] args) {
        Observer hospital = new Hospital();
        Person person = new Person("Pesho");
        person.add(hospital);
        person.lift();
        person.lift();
        person.lift();
        person.lift();
        person.lift();
        person.lift();
    }
}