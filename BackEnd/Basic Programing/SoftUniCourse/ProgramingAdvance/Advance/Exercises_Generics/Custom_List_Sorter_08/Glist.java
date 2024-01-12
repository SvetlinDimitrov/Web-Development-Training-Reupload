package JavaAdvance.Exercises_Generics.Custom_List_Sorter_08;

import java.util.*;
import java.util.stream.Collectors;

public class Glist<T extends Comparable> {
    private List<T> elements;
    private int size;

    public Glist(){
        elements = new ArrayList<>();
        size =0;
    }

    public void add(T element){
        elements.add(element);
        size++;
    }

    public T remove(int index){
        if(!ValidIndex(index)){
            throw new IllegalArgumentException("yes");
        }
        T element = elements.get(index);
        elements.remove(index);
        size--;
        return element;
    }

    public boolean contains(T element){
        return elements.contains(element);
    }

    public void swap(int swap1 , int swap2){
        Collections.swap(elements , swap1 , swap2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(String.format("%s%n",element));
        }
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    public int countGreaterThen(T element){
        int count =0;
        for (T t : elements) {
            if(element.compareTo(t) <0){
                count++;
            }
        }
        return count;
    }

    public T getMax(){
        return elements.stream().max((first , second)-> first.compareTo(second)).get();
    }

    public T getMin(){
        return elements.stream().min((first , second)-> first.compareTo(second)).get();
    }

    public void sort(){
        elements = elements.stream().sorted((first , second) -> first.compareTo(second)).collect(Collectors.toList());
    }

    private boolean ValidIndex(int index) {
        return index <= size-1 || index > 0;
    }
}

