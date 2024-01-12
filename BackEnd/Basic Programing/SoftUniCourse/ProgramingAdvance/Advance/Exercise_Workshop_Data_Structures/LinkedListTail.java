package JavaAdvance.Exercise_Workshop_Data_Structures;

import java.util.function.Consumer;

public class LinkedListTail {
    private static class Node{
        private Node prev;
        private int element;

        private Node(int element){
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element){
        Node nodeToAdd = new Node(element);
        if(size == 0){
            head = nodeToAdd;
            tail = nodeToAdd;
            size++;
        }else{
            Node copy = head;
            head = nodeToAdd;
            head.prev = copy;
            size++;
        }
    }

    public int removeFirst(){
        if(size == 0){
            throw new IllegalArgumentException("Fuck you , nO Space");
        }
        int removedElement = head.element;
        head = head.prev;
        size--;
        return removedElement;
    }

    public void addLast(int element){
        if(size == 0){
            addFirst(element);
        }else{
            Node nodeToAdd = new Node(element);
            tail.prev = nodeToAdd;
            tail = nodeToAdd;
            size++;
        }
    }

    public int removeLast() {
        int elementToReturn;
        if (size == 0) {
            throw new IllegalArgumentException("Fuck you , nO Space");
        } else if (size == 1) {
            elementToReturn = head.element;
            size--;
            head = null;
            tail = null;
            return elementToReturn;
        } else {
            Node copyNode = head;
            while (copyNode.prev.prev != null) {
                copyNode = copyNode.prev;
            }
            elementToReturn = copyNode.prev.element;
            copyNode.prev = null;
            tail = copyNode;
            size--;
            return elementToReturn;
        }
    }

    public int get(int index){
        if(index <=0 || index > size){
            throw new IllegalArgumentException("Nz ko prai6  ama nqma kak da stane");
        }
        if(size== 1){
            return tail.element;
        }
        Node copyNode = head;
        int count = 1;
        while(count != index){
            count++;
            copyNode = copyNode.prev;
        }
        return copyNode.element;
    }

    public void forEach(Consumer<Integer> cats){
        if (size == 0) {
            throw new IllegalArgumentException("Fuck you , nO Space");
        }
        int count = 0;
        Node copyNode = head;
        while(count !=size){
            count++;
            cats .accept(copyNode.element);
            copyNode = copyNode.prev;
        }

    }

    public int[] toArray(){
        int [] arr = new int [size];
        int count =0;
        Node nodeCopy = head;
        while(count != size){
            arr[count]= nodeCopy.element;
            nodeCopy = nodeCopy.prev;
            count++;
        }
        return arr;
    }
}

