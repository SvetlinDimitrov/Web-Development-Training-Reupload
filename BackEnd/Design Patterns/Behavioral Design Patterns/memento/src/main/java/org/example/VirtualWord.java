package org.example;

import java.util.ArrayDeque;

public class VirtualWord {
    private final ArrayDeque<Person.Memento> mementos;
    private final Person person;

    public VirtualWord() {
        this.mementos = new ArrayDeque<>();
        this.person = new Person("pesho");
    }

    public void save(){
        Person.Memento memento = person.createMemento();
        mementos.push(memento);
    }
    public void sleep(){
        person.setEnergy(person.getEnergy() + 0.5);
    }

    public void workout(){
        person.setEnergy(person.getEnergy() - 0.2);
        person.setPower(person.getPower() + 5);
    }

    public void eatJunk(){
        person.setEnergy(person.getEnergy() + 0.5);
        person.setPower(person.getPower() - 5);
    }

    public void eatHealthy(){
        person.setEnergy(person.getEnergy() + 0.1);
        person.setPower(person.getPower() + 5);
    }

    public void goBack(){
        if(mementos.size() == 0){
            System.out.println("you can't go back anymore");
            return;
        }
        person.restoreMemento(mementos.pop());
    }

    public Person getPerson(){
        return new Person(person);
    }

    public void setCharacterName(String name){
        this.person.setName(name);
    }

    public void flex(){
        System.out.println(person);
    }


}
