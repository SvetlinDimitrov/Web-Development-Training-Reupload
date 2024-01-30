package org.example;

public class InterpreterExample {

    static class Pizza {
        private String ingredients = "Normal pizza";

        public String showIngredients() {
            return ingredients;
        }

        public void modifyIngredients(String bonus) {
            ingredients = String.format("%s +\n%s", ingredients, bonus);
        }
    }

    interface Interpreter {
        void modifyPizza(Pizza pizza);
    }

    static class TomatoAdder implements Interpreter {

        @Override
        public void modifyPizza(Pizza pizza) {
            pizza.modifyIngredients("Tomato was added");
        }

    }

    static class CucumberAdder implements Interpreter {

        @Override
        public void modifyPizza(Pizza pizza) {
            pizza.modifyIngredients("Cucumbers added");
        }
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        System.out.println(pizza.showIngredients());

        Interpreter interpreter = new TomatoAdder();
        Interpreter interpreter1 = new CucumberAdder();
        interpreter1.modifyPizza(pizza);
        interpreter.modifyPizza(pizza);
        interpreter1.modifyPizza(pizza);

        System.out.println(pizza.showIngredients());
    }
}
