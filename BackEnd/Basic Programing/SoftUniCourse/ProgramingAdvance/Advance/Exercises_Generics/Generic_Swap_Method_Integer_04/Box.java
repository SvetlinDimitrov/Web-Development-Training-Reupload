package JavaAdvance.Exercises_Generics.Generic_Swap_Method_Integer_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private List<T> numbers;

    public Box(){
        numbers = new ArrayList<>();
    }

    public void add(T element){
        numbers.add(element);
    }

    public void swap(int swap1 , int swap2){
        Collections.swap(numbers , swap1 , swap2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T number : numbers) {
            sb.append(String.format("%s: %s%n" , number.getClass().getName() , number));
        }
        return sb.toString();
    }
}
