package JavaAdvance.Exercises_Generics.Generic_Box_01;

import java.util.ArrayList;
import java.util.List;

public class Box<T>{
    private List<T> list;

    public Box(){
        list = new ArrayList<>();
    }

    public void add(T input){
        list.add(input);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(String.format("%s: %s%n",t.getClass().getName() , t));
        }
        return sb.toString();
    }
}
