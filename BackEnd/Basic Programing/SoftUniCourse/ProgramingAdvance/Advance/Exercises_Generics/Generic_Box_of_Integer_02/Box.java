package JavaAdvance.Exercises_Generics.Generic_Box_of_Integer_02;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> numbers;

    public Box(){
        numbers = new ArrayList<>();
    }

    public void add(T element){
        numbers.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T number : numbers) {
            sb.append(String.format("%s: %s%n",number.getClass().getName() , number));
        }
        return sb.toString();
    }
}
