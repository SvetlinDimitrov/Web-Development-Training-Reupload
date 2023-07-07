package org.example;

import org.example.styles.Aikido;
import org.example.styles.Jujutsu;

public class Main {
    public static void main(String[] args) {
        Fighter fighter = new Fighter("Gosho");
        fighter.fight();
        fighter.setStyle(new Jujutsu());
        fighter.fight();
        fighter.setStyle(new Aikido());
        fighter.fight();
    }
}