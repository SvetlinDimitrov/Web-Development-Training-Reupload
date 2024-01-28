package org.example;

public class DecoderExample {

    interface Product {
        String getInfoIngredients();
    }

    static class ProductA implements Product {

        @Override
        public String getInfoIngredients() {
            return "15 carbs , 5 fat , 20 protein";
        }
    }

    static class DecoderMineralInfo implements Product {

        private final Product product;

        DecoderMineralInfo(Product product) {
            this.product = product;
        }

        @Override
        public String getInfoIngredients() {
            String infoIngredients = product.getInfoIngredients();
            return String.format(infoIngredients + "\n" + "minerals = very low");
        }
    }

    static class DecoderVitaminInfo implements Product {

        private final Product product;

        DecoderVitaminInfo(Product product) {
            this.product = product;
        }


        @Override
        public String getInfoIngredients() {
            String infoIngredients = product.getInfoIngredients();
            return String.format(infoIngredients + "\n" + "Vitamin = good");
        }
    }

    public static void main(String[] args) {
        Product product = new ProductA();
        System.out.println(product.getInfoIngredients());
        System.out.println("---------------------------------------------------------------------------");
        DecoderMineralInfo decoderMineralInfo = new DecoderMineralInfo(new DecoderVitaminInfo(product));
        System.out.println(decoderMineralInfo.getInfoIngredients());
    }
}
