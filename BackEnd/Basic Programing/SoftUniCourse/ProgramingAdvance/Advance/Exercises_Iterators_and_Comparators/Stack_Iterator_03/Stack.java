package JavaAdvance.Exercises_Iterators_and_Comparators.Stack_Iterator_03;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Stack implements Iterable<Integer> {
    private ArrayDeque<Integer> stack;

    public Stack() {
        stack = new ArrayDeque<>();
    }

    public void add(Integer elem){
        stack.push(elem);
    }

    public Integer pop(){
        return stack.pop();
    }

    public void printAl(){
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iteratora();
    }

    private  class Iteratora implements Iterator<Integer>{

        ArrayDeque<Integer> copyStack = stack;
        int size = 0;


        @Override
        public boolean hasNext() {
            if(size <= stack.size()-1 ){
                size++;
                return true;
            }
            return false;
        }
        @Override
        public Integer next() {
            return copyStack.pop();
        }
    }
}
