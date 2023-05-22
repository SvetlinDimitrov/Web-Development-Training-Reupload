package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private static class Node<E>{
        private E element ;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
    private Node<E> head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> toAdd = new Node<E>(element);
        if(size != 0 ){
            head.next = head;
            head = toAdd;
        }else{
            head = toAdd;
        }
        size++;
    }

    @Override
    public E pop() {
        if(size == 0){
            throw new IllegalStateException();
        }
        E element = head.element;
        head = head.next;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if(size == 0){
            throw new IllegalStateException();
        }
        return head.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            Node<E> copyNode= head;

            @Override
            public boolean hasNext() {
                return copyNode.next != null;
            }


            E element = copyNode.element;

            @Override
            public Object next() {
                copyNode = copyNode.next;
                return element;
            }
        };
    }
}
