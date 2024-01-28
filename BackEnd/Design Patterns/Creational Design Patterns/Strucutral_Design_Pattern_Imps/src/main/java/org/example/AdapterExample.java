package org.example;

public class AdapterExample {
    interface Adaptee {
        void showIngredientInfo();
    }

    static class NotUnderstandableProduct {
        private final String INGREDIENTS = "????";


        public void showIngredientInfo() {
            System.out.println(INGREDIENTS);
        }

        public String getINGREDIENTS() {
            return INGREDIENTS;
        }
    }

    static class AdapteeImp implements Adaptee {

        private final NotUnderstandableProduct product;

        public AdapteeImp(NotUnderstandableProduct product) {
            this.product = product;
        }

        @Override
        public void showIngredientInfo() {
            String ingredients = product.getINGREDIENTS();
            //Doing something with this
            System.out.println("124 carbs , fat = 0 , protein = 1");
        }
    }

    public static void main(String[] args) {
        AdapteeImp adapter = new AdapteeImp(new NotUnderstandableProduct());
        adapter.showIngredientInfo();
    }
}