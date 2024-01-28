package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeExample {

    interface Product {
        void showInfo();
    }

    static class LeafProduct implements Product {
        @Override
        public void showInfo() {
            System.out.println("Show info about this item");
        }
    }

    static class CompositeImp implements Product {

        private final List<Product> productList;

        CompositeImp(Product... productList) {
            this.productList = new ArrayList<>(Arrays.stream(productList).toList());
        }

        public void addChild(Product product) {
            productList.add(product);
        }

        public void removeChild(Product product) {
            productList.remove(product);
        }

        @Override
        public void showInfo() {
            System.out.println("More info from me");
            productList.forEach(Product::showInfo);
        }
    }

    public static void main(String[] args) {

        LeafProduct leafProduct = new LeafProduct();
        CompositeImp compositeImp = new CompositeImp(new LeafProduct(), new LeafProduct(), new LeafProduct());
        CompositeImp compositeImp2 = new CompositeImp(compositeImp);
        CompositeImp compositeImp3 = new CompositeImp(compositeImp2);
        leafProduct.showInfo();
        compositeImp3.addChild(leafProduct);
        compositeImp3.showInfo();

    }
}
