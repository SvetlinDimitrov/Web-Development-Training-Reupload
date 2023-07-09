package org.example;

public interface Observables {
    void add(Observer observer);
    void remove(Observer observer);
    void notifyObserver();
    Integer getHealth();
    void restoreHealth(Integer health);
    String getName();
}
