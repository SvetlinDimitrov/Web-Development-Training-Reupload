package org.example;

public class Hospital implements Observer{

    @Override
    public void update(Observables observables) {
        if(observables.getHealth() <= 20){
            System.out.println(observables.getName() + " the state is critical");
            observables.restoreHealth(40);
            System.out.println(observables.getName() + " has been health by 40");
        }
    }
}
