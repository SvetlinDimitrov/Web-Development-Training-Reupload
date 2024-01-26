public class Main {

  public static void main(String[] args) {
    order(new PizzaDecodeCheese(new PizzaDecodeCheese(new PizzaMargherita())));
    order(new PizzaHawaiian());
    order(new PizzaPepperoni());
  }

  public static void order(Pizza pizza) {
    System.out.println("You have ordered a " + pizza.getName() +
        " pizza. The toppings are " + pizza.getToppings() + ".");
  }

}
