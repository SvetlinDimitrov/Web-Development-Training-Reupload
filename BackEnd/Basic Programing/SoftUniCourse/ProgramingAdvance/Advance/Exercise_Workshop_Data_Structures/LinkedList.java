package JavaAdvance.Exercise_Workshop_Data_Structures;

import java.util.function.Consumer;

public class LinkedList {
    private static class Node{
        private int element;
        private Node prev ;

        private Node(int element){
            this.element = element;
        }
    }

    private Node head ;
    private int size = -1;

    public void addFirst(int element){
        size++;
        Node newNode = new Node(element);
        Node saveNode = head;
        head = newNode;
        head.prev =  saveNode;
    }

    public void addLast(int element){
        size++;
        if(size ==0){
            addFirst(element);
            size--;
        }else {
            Node newNode = new Node(element);
            Node copyHead = head;
            while(copyHead.prev !=null){
                copyHead = copyHead.prev;
            }
            copyHead.prev = newNode;
        }
    }

    public int get(int index){
        if(ValidIndex(index)){
            throw new IllegalArgumentException("Nqma nishto v lista ti e  ");
        }else{
            int indexToSearch = 0;
            Node copyNode = head;
            while (indexToSearch != index){
                copyNode = copyNode.prev;
                indexToSearch++;
            }
            return copyNode.element;
        }
    }


    public int removeFirst(){
        if(size == -1){
            throw new IllegalArgumentException("Nqma nishto v lista ti e  ");
        }else{
            int deleteElement = head.element;
            head = head.prev;
            return deleteElement;
        }
    }

    public int removeLast(){
        if(size == -1){
            throw new IllegalArgumentException("Nqma nishto v lista ti e  ");
        }else if (size == 0){
            int returnValue = head.element;
            head = null;
            size--;
            return returnValue;
        }else {
            Node copyHead = head;
            while (copyHead.prev.prev != null) {
                copyHead = copyHead.prev;
            }
            int deleteElement = copyHead.prev.element;
            copyHead.prev = null;
            size--;
            return deleteElement;
        }
    }

    public void forEach(Consumer<Integer> yes){
        Node copyNode = head;
        while(copyNode.prev != null){
            yes.accept(copyNode.element);
            copyNode = copyNode.prev;
        }
        yes.accept(copyNode.element);
    }
    private boolean ValidIndex(int index) {
        return index < 0 || index > size;
    }

    public int[] toArray(){
        int [] copyList = new int [size+1];
        Node copyNode = head;
        int count =0;
        while(copyNode.prev != null){
            copyList[count] = copyNode.element;
            count++;
            copyNode = copyNode.prev;
        }
        copyList[count] = copyNode.element;
        return copyList;
    }
    public int getSize(){
        return size+1;
    }
}
