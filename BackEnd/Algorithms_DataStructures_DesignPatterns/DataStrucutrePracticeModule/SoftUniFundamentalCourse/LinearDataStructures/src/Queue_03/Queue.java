package Queue_03;

import Queue_03.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {

    private Node<E> head;
    private int size;

    public Queue() {
        Node<E> head = null;
        size =0;
    }
    @Override
    public void offer(E element) {
        Node<E> toAdd = new Node<>(element);
        if(size == 0) {
            head = toAdd;
        }else{
            Node<E> copyHead = head;
            while(copyHead.next != null){
                copyHead = copyHead.next;
            }
            copyHead.next = toAdd;
        }
        size++;
    }

    @Override
    public E poll() {
        if(size==0){
            throw new IllegalStateException();
        }
        E element = head.element;
        head = head.next;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if(size ==0){
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
        return size==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> copyNode = head;
            @Override
            public boolean hasNext() {
                return copyNode.next != null;
            }


            @Override
            public E next() {
                E element = copyNode.element;
                copyNode = copyNode.next;
                return element;
            }

        };
    }





    private  static class Node<E>{
        Node<E> next ;
        E element;

        public Node(E element) {
            this.element = element;
        }
    }
}
