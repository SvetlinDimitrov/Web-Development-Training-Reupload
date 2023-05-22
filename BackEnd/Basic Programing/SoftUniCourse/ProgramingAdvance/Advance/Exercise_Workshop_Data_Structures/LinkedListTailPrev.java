package JavaAdvance.Exercise_Workshop_Data_Structures;

import java.util.function.Consumer;

public class LinkedListTailPrev {
    private static class Node{
        private Node prev;
        private Node next;
        private int element;

        private Node(int element){
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element){
        Node newNode = new Node(element);
        if(size == 0) {
            tail = newNode;
            head = newNode;
        }else if (size == 1){
            tail.next = newNode;
            head = newNode;
            head.prev = tail;
        }else{
            head.next = newNode;
            Node saveNode = head;
            head = newNode;
            head.prev = saveNode;
        }
        size++;
    }

    public void addLast(int element){
        Node newNode = new Node(element);
        if(size == 0) {
            tail = newNode;
            head = newNode;
        }else if (size == 1){
            tail.prev = newNode;
            tail = newNode;
            tail.next = head;
        }else{
            tail.prev = newNode;
            Node saveNode = tail;
            tail = newNode;
            tail.next = saveNode;
        }
        size++;
    }

    public int removeFirst(){
        int returnElement;
        if(size ==0){
            throw new IllegalArgumentException("Нямаш нищо бра");
        }else if(size==1){
            returnElement = head.element;
            head = null;
            tail = null;
        }else {
            returnElement = head.element;
            head = head.prev;
            head.next = null;
        }
        size--;
        return returnElement;
    }

    public int removeLast(){
        int returnElement;
        if(size ==0) {
            throw new IllegalArgumentException("Нямаш нищо бра");
        }else if(size==1){
            returnElement = head.element;
            head = null;
            tail = null;
        }else{
            returnElement = tail.element;
            tail = tail.next;
            tail.prev=null;
        }
        size--;
        return returnElement;
    }

    public int get(int index){
        int elementToReturn =0;
        if(index > size || index <= 0){
            throw new IllegalArgumentException("Bra no elements duuaaa");
        }
        int currentIndexToReturn = 0;
        if(size/2 < index){
            currentIndexToReturn = size - index;
            Node nodeCopy = tail;
            while(currentIndexToReturn != 0){
                nodeCopy = nodeCopy.next;
                currentIndexToReturn--;
            }
            elementToReturn = nodeCopy.element;
        }else{
            currentIndexToReturn = index;
            Node nodeCopy = head;
            while(currentIndexToReturn != 1){
                nodeCopy = nodeCopy.prev;
                currentIndexToReturn--;
            }
            elementToReturn = nodeCopy.element;
        }
        return elementToReturn;
    }

    public void forEach(Consumer<Integer>cats){
        Node copyNode = head;
        int elements = size;
        while (elements != 0){
            cats.accept(copyNode.element);
            copyNode = copyNode.prev;
            elements--;
        }
    }

    public int [] toArray (){
        Node nodeCopy = head;
        int sizeCopy = size;
        int count = 0;
        int [] arrayToReturn = new int [size];
        while(sizeCopy != 0){
            arrayToReturn[count] = nodeCopy.element;
            count++;
            sizeCopy--;
            nodeCopy = nodeCopy.prev;
        }
        return arrayToReturn;
    }
}
