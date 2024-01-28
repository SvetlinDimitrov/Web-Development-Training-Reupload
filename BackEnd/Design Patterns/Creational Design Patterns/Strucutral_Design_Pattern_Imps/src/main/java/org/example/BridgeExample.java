package org.example;

public class BridgeExample {

    interface Product {
        void getInfo();
    }


    static class Cucumber implements Product {

        private final Ingredients ingredients;

        Cucumber(Ingredients ingredients) {
            this.ingredients = ingredients;
        }

        @Override
        public void getInfo() {
            System.out.println(ingredients.getIngInfo());
        }
    }


    static class Tomato implements Product {

        private final Ingredients ingredients;

        Tomato(Ingredients ingredients) {
            this.ingredients = ingredients;
        }

        @Override
        public void getInfo() {
            System.out.println(ingredients.getIngInfo());
        }
    }


    interface Ingredients {
        String getIngInfo();
    }

    static class GMO implements Ingredients {

        @Override
        public String getIngInfo() {
            return "Only GMO";
        }
    }

    static class BIO implements Ingredients {

        @Override
        public String getIngInfo() {
            return "Half good , but other half GMO";
        }
    }

    static class IN_YOUR_GARDEN implements Ingredients {

        @Override
        public String getIngInfo() {
            return "If its not dead , perfect health";
        }
    }

    public static void main(String[] args) {
        Product cucumber = new Cucumber(new GMO());
        Product tomato = new Tomato(new IN_YOUR_GARDEN());
        cucumber.getInfo();
        tomato.getInfo();
    }
}
