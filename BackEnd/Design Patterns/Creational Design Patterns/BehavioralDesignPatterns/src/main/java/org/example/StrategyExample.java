package org.example;

public class StrategyExample {

    interface Strategy {
        void attack();

        static Strategy createSwordAttackStrategy() {
            return () -> System.out.println("Sword attack!");
        }

        static Strategy createHammerAttackStrategy() {
            return () -> System.out.println("Hammer attack!");
        }

        static Strategy defenceStrategy() {
            return () -> System.out.println("Dodge mode on !");
        }
    }

    static class Person {
        public void executeStrategy(Strategy strategy) {
            strategy.attack();
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.executeStrategy(Strategy.defenceStrategy());
        person.executeStrategy(Strategy.createHammerAttackStrategy());
    }
}
