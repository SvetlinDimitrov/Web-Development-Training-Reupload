package JavaAdvance.Workshop_Custom_Data_Structures;

import java.util.function.Consumer;

public class Steck {
    private static class Node{
        private int element ;
        private Node prev;

        private Node(int element){
            this.element =element;
        }
    }
    private Node top;
    private int size;

    public void push(int element){
        Node newNode = new Node(element);
        newNode.prev = top;
        top = newNode;
        size++;
    }

    public int pop(){
        if(top.prev == null){
            throw new IllegalArgumentException("Gei");
        }
        int value = top.element;
        top = top.prev;
        size--;
        return value;
    }

    public int peek(){
        return top.element;
    }

    public void forEach(Consumer<Integer> consumer){
        Node afk = top;

        while(afk != null){
            consumer.accept(afk.element);
            afk = afk.prev;
        }
    }
}
