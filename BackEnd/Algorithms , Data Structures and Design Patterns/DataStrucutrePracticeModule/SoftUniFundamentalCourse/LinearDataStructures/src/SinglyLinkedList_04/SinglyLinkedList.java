package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        size=0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> nodeToAdd = new Node<>(element);
        if(size == 0){
            head = nodeToAdd;
            tail = nodeToAdd;
        }else {
            Node<E> copyNode = head;
            head.prev = nodeToAdd;
            head = nodeToAdd;
            head.next = copyNode;
        }
            size++;
    }


    @Override
    public void addLast(E element) {
        Node<E> nodeToAdd = new Node<>(element);
        if(size == 0) {
            head = nodeToAdd;
            tail = nodeToAdd;
        }else{
            Node<E> copyNode = tail;
            tail.next = nodeToAdd;
            tail = nodeToAdd;
            tail.prev = copyNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if(size==0){
            throw new IllegalStateException();
        }
        E element = head.element;
        head=head.next;
        head.prev = null;
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        if(size==0){
            throw new IllegalStateException();
        }
        E element = tail.element;
        tail = tail.prev;
        tail.next = null;
        size--;
        return element;
    }

    @Override
    public E getFirst() {
        if(size ==0){
            throw new IllegalStateException();
        }
        return head.element;
    }

    @Override
    public E getLast() {
        if(size ==0){
            throw new IllegalStateException();
        }
        return tail.element;
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
        return new Iterator<E>() {
            Node<E> copyNode = head;
            @Override
            public boolean hasNext() {
                return copyNode.next != null;
            }

            @Override
            public E next() {
                E element  = copyNode.element;
                copyNode = copyNode.next;
                return element;
            }
        };
    }



    private static class Node<E>{
        E element ;
        Node<E> next;
        Node<E> prev;

        public Node(E element) {
            this.element = element;
        }
    }
}
