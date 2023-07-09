package org.example;

import java.util.ArrayList;
import java.util.List;

public class Person implements Observables{
    private final String name;

    private final List<Observer> observerList;
    private Integer health;

    public Person(String name) {
        this.name = name;
        this.observerList = new ArrayList<>();
        this.health = 100;
    }

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(o->o.update(this));
    }

    @Override
    public Integer getHealth() {
        return health;
    }

    @Override
    public void restoreHealth(Integer health) {
        this.health += health;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void lift(){
        this.health -= 20;
        notifyObserver();
    }
}
