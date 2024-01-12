package JavaAdvance.Generics_Lab.Jar;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {
    private List<T> elements;
    private int size;
    public Jar(){
        elements = new ArrayList<>();
    }
    public void add(T element){
        elements.add(element);
        size++;
    }

    public T remove(){
        T integer = elements.get(size-1);
        elements.remove(size-1);
        size--;
        return integer;
    }
}
