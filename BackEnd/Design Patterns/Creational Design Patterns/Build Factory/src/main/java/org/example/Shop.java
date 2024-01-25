package org.example;

public class Shop {
    static abstract class Product {
        protected Product() {
        }
    }

    static class Chocolate extends Product {
        public Chocolate() {
            System.out.println("Normal chocolate was added");
        }
    }

    static class ChocolateFactory implements Factory {
        @Override
        public Product addProduct() {
            return new Chocolate();
        }
    }

    static class DarkChocolate extends Product {
        public DarkChocolate() {
            System.out.println("Dark chocolate was added");
        }
    }

    static class DarkChocolateFactory implements Factory {
        @Override
        public Product addProduct() {
            return new DarkChocolate();
        }
    }

    static class WhiteChocolate extends Product {
        public WhiteChocolate() {
            System.out.println("White chocolate was added");
        }
    }

    static class WhiteChocolateFactory implements Factory {
        @Override
        public Product addProduct() {
            return new WhiteChocolate();
        }
    }

    static class Chips extends Product {
        public Chips() {
            System.out.println("Chips was added");
        }
    }

    static class ChipsFactory implements Factory {

        @Override
        public Product addProduct() {
            return new Chips();
        }
    }

    static class Sugar extends Product {
        public Sugar() {
            System.out.println("Sugar was added");
        }
    }

    static class SugarFactory implements Factory {

        @Override
        public Product addProduct() {
            return new Sugar();
        }
    }

    interface Factory {
        Product addProduct();
    }

    public static void main(String[] args) {
        Factory chocolateFactory = new ChocolateFactory();
        Factory whiteChocolateFactory = new WhiteChocolateFactory();
        Factory datkChocolateFactory = new DarkChocolateFactory();
        Factory sugar = new SugarFactory();
        Factory chips = new ChipsFactory();
        Product product = chocolateFactory.addProduct();
        Product product1 = chocolateFactory.addProduct();
        Product product2 = whiteChocolateFactory.addProduct();
    }
}
