package org.example;

public class Person {
    private String name;
    private Double energy;
    private Integer power;

    public Person(String name) {
        this.name = name;
        energy = 1.00;
        power = 0;
    }

    public Person(Person person){
        this.name = person.name;
        this.energy = person.energy;
        this.power = person.power;
    }


    public Memento createMemento(){
        return new Memento(energy, power);
    }

    public void restoreMemento(Memento memento){
        this.energy = memento.energy;
        this.power = memento.power;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", power=" + power +
                '}';
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEnergy() {
        return energy;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public static class Memento{

        private final Double energy;
        private final Integer power;

        public Memento(Double energy, Integer power) {
            this.energy = energy;
            this.power = power;
        }
    }

}
