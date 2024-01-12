package JavaAdvance.Exercises_Iterators_and_Comparators.Collection_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int size;
    private int index;

    public ListyIterator() {
        this.list = new ArrayList<>();
        size = 0;
        index=0;
    }

    public boolean hasNext(){
        return index < size-1;
    }

    public boolean move(){
        if(hasNext()){
            index++;
            return true;
        }
        return false;
    }

    public void add(String elem){
        list.add(elem);
        size++;
    }

    public void print(){
        if(size==0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(list.get(index));
    }

    public void printAll(){
        if(size==0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        for (String s : list){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }
}
