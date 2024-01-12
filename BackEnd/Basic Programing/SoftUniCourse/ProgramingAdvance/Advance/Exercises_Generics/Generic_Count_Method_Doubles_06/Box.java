package JavaAdvance.Exercises_Generics.Generic_Count_Method_Doubles_06;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable> {
    private List<T> elements;

    public Box(){
        elements = new ArrayList<>();
    }

    public void add(T element){
        elements.add(element);
    }

    public int count(T el){
        int times = 0;
        for (T element : elements) {
            if(el.compareTo(element) < 0){
                times++;
            }
        }
        return times;
    }
}
