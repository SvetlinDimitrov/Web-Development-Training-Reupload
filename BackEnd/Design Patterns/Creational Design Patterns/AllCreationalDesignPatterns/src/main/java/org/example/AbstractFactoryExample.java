package org.example;

public class AbstractFactoryExample {

    interface Product {
    }

    static class Cucumber implements Product {
    }

    static class GreenCucumber extends Cucumber {
    }

    static class PurpleCucumber extends Cucumber {
    }

    static class Tomato implements Product {
    }

    static class GreenTomato extends Tomato {
    }

    static class RedTomato extends Tomato {
    }

    interface AbstractFactory {
        Product createCucumber();

        Product createTomato();
    }

    static class FirstCombinationFactory implements AbstractFactory {

        @Override
        public GreenCucumber createCucumber() {
            return new GreenCucumber();
        }

        @Override
        public GreenTomato createTomato() {
            return new GreenTomato();
        }
    }

    static class SecondCombinationFactory implements AbstractFactory {

        @Override
        public RedTomato createCucumber() {
            return new RedTomato();
        }

        @Override
        public PurpleCucumber createTomato() {
            return new PurpleCucumber();
        }
    }

    static class ThirdCombinationFactory implements AbstractFactory {

        @Override
        public GreenTomato createCucumber() {
            return new GreenTomato();
        }

        @Override
        public PurpleCucumber createTomato() {
            return new PurpleCucumber();
        }
    }

    public static void main(String[] args) {
        FirstCombinationFactory firstFactory = new FirstCombinationFactory();
        GreenCucumber cucumber = firstFactory.createCucumber();
        GreenTomato tomato = firstFactory.createTomato();

        SecondCombinationFactory secondFactory = new SecondCombinationFactory();
        RedTomato cucumber1 = secondFactory.createCucumber();
        PurpleCucumber tomato1 = secondFactory.createTomato();

        ThirdCombinationFactory thirdFactory = new ThirdCombinationFactory();
        GreenTomato cucumber2 = thirdFactory.createCucumber();
        PurpleCucumber tomato2 = thirdFactory.createTomato();
    }
}
