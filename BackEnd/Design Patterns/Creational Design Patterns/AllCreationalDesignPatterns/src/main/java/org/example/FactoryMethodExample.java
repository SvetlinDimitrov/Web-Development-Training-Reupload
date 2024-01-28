package org.example;

public class FactoryMethodExample {
    interface Product {
    }

    ;

    static class Veggie implements Product {
    }

    static class Cucumber implements Product {
    }

    interface Factory {
        Product createItem();
    }

    static class VeggieFactory implements Factory {

        @Override
        public Veggie createItem() {
            return new Veggie();
        }
    }

    static class CucumberFactory implements Factory {

        @Override
        public Cucumber createItem() {
            return new Cucumber();
        }
    }

    public static void main(String[] args) {
        CucumberFactory factory = new CucumberFactory();
        Cucumber item = factory.createItem();
        VeggieFactory veggieFactory = new VeggieFactory();
        Veggie item1 = veggieFactory.createItem();
    }
}
