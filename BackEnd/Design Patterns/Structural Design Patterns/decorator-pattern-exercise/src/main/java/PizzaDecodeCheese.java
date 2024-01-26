import java.util.ArrayList;

public class PizzaDecodeCheese extends PizzaDecode{

    protected PizzaDecodeCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public ArrayList getToppings() {
        ArrayList toppings = pizza.getToppings();
        toppings.add("extra cheese");
        return toppings;
    }

    @Override
    public String getName() {
        return pizza.getName();
    }
}
