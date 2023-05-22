import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name,int numberOfToppings ) {
        setName(name);
        setToppings(numberOfToppings);


    }

    private void setName(String name) {
        if(name !=  null && name.trim().length() >1 && name.length() <=15){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if(!(numberOfToppings >=0 && numberOfToppings <=10)){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void addTopping(Topping shit){
        if(toppings.size() >= 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10]");
        }
        toppings.add(shit);
    }
    public double getOverallCalories(){
        double sumTop =0;
        for (Topping topping : toppings) {
            sumTop+=topping.calculateCalories();
        }
        return dough.calculateCalories() + sumTop;
    }
}
