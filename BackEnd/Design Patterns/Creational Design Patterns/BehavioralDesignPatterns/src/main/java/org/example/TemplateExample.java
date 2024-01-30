package org.example;

public class TemplateExample {

    abstract static class PizzaMaker {
        abstract void bake();

        abstract void addTomato();

        abstract void addSomethingNew();

        public void makePizza() {
            bake();
            addTomato();
            addSomethingNew();
            System.out.println("Pizza is finished");
        }
    }

    static class Margarita extends PizzaMaker {

        @Override
        void bake() {
            System.out.println("Bake for 30 secs");
        }

        @Override
        void addTomato() {
            System.out.println("Add 30 tomatoes");
        }

        @Override
        void addSomethingNew() {
            System.out.println("Margarita secret");
        }
    }

    static class MargaritaExtra extends PizzaMaker {

        @Override
        void bake() {
            System.out.println("Bake for 32 secs");
        }

        @Override
        void addTomato() {
            System.out.println("Add 32 tomatoes");
        }

        @Override
        void addSomethingNew() {
            System.out.println("x2 Margarita secret");
        }
    }

    public static void main(String[] args) {
        PizzaMaker pizzaMaker = new Margarita();
        PizzaMaker pizzaMaker1 = new MargaritaExtra();

        pizzaMaker1.makePizza();
        pizzaMaker.makePizza();
    }
}
