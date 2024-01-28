package org.example;

public class ProxyExample {

    interface Product {
        String showInfo();
    }

    static class ProductImp implements Product {

        @Override
        public String showInfo() {
            return "124 fat , 100 carbs , 200 protein";
        }
    }

    static class ProxyProduct implements Product {

        private final Product product;
        private boolean subscription = false;

        public ProxyProduct(Product product) {
            this.product = product;
        }

        @Override
        public String showInfo() {
            if (!subscription) {
                return "You need to be subscribe to view to Info";
            }
            return product.showInfo();
        }

        public void subscribe() {
            subscription = true;
        }
    }

    public static void main(String[] args) {
        ProxyProduct proxyExample = new ProxyProduct(new ProductImp());
        System.out.println(proxyExample.showInfo());
        proxyExample.subscribe();
        System.out.println(proxyExample.showInfo());
    }
}
