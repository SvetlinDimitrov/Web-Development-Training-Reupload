import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String pizzaName = input.split(" ")[1];
        int numToppings = Integer.parseInt(input.split(" ")[2]);
        input = scanner.nextLine();
        String doughType = input.split(" ")[1];
        String bakingTechnique = input.split(" ")[2];
        double weightInGrams = Double.parseDouble(input.split(" ")[3]);
        try {
            Pizza pizza = new Pizza(pizzaName,numToppings);
            pizza.setDough( new Dough(doughType, bakingTechnique, weightInGrams));
            input = scanner.nextLine();
            while (!input.equals("END")) {

                String toppingType = input.split(" ")[1];
                weightInGrams = Double.parseDouble(input.split(" ")[2]);
                try {
                    pizza.addTopping(new Topping(toppingType, weightInGrams));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                input = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
