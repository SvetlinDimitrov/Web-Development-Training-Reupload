package implementations;

import interfaces.Deque;

import java.util.Iterator;
import java.util.Stack;

public class ArrayDeque<E> implements Deque<E> {
    private static final int START_SIZE = 7;
    private int head;
    private int tail;
    private int size;
    private Object [] array ;

    public ArrayDeque() {
        this.array = new Object[START_SIZE];
        this.size =0;
    }

    @Override
    public void add(E Element) {
        if(isEmpty()){
            this.head = this.tail = 3;
            this.array[head] = Element;
        }else{
            this.tail++;
            if(this.tail > this.array.length-1){
                array = grow(array);
                add(Element);
            }else{
                this.array[tail] = Element;
            }
        }
        size++;
    }

    @Override
    public void offer(E element) {
        if(isEmpty()){
            add(element);
        }else{
            this.head--;
            if(this.head < 0 ){
                array = grow(array);
                offer(element);
            }else{
                this.array[head] = element;
            }
            size++;
        }

    }

    @Override
    public void addFirst(E element) {
        offer(element);
    }

    @Override
    public void addLast(E element) {
        add(element);
    }

    @Override
    public void push(E element) {
        offer(element);
    }

    @Override
    public void insert(int index, E element) {
        if(ValidIndex(index)){
            int realInsertIndex = this.head +index;
            if(index < size/2 ){
                head--;
                if(head < 0){
                    array = grow(array);
                    realInsertIndex = this.head +index;
                }
                addWithHead(realInsertIndex , array);
                array[realInsertIndex-1] = element;
            }else{
                tail++;
                if(tail > array.length-1){
                    array = grow(array);
                    tail++;
                    realInsertIndex = this.head +index;
                }
                addWithTail(realInsertIndex , array);
                array[realInsertIndex] = element;
            }
        }else{
            throw new IndexOutOfBoundsException();
        }
        size++;
    }

    @Override
    public void set(int index, E element) {
        if(ValidIndex(index)){
            array[head+index] = element;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E peek() {
        if(size==0) {
            return null;
        }else{
            return (E) array[head];
        }
    }

    @Override
    public E poll() {
        if(isEmpty()) {
            return null;
        }else{
            E element = (E) array[head];
            if(size == 1 ){
                array[head] = null;
                tail = head = 0;
            }else{
                array[head] = null;
                head++;
            }
            size--;
            return element;
        }
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            return null;
        }else{
            E element = (E)array[tail];
            if(size == 1){
                array[tail] = null;
                head = tail = 0;
            }else{
                array[tail] = null;
                tail--;
            }
            size--;
            return element;
        }
    }

    @Override
    public E get(int index) {
        if (ValidIndex(index)){
            return  (E) array[head+index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E get(Object object) {
        for (int i = 0; i < size; i++) {
            if(array[head+i].equals(object)){
                return (E) array[head+i];
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        if(ValidIndex(index)){
            E element = (E) array[index+head];
            array[index+head] = null;
            for (int i = index+head; i < tail; i++) {
                array[i] = array[i+1];
            }
            array[tail] = null;
            tail--;
            size--;
            return element;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E remove(Object object) {
        Object toReturn = null;
        int saveHead=-1;
        for (int i = head; i <= tail; i++) {
            if(array[i].equals(object)){
                toReturn = (E) array[i];
                saveHead=i;
                break;
            }
        }
        if(saveHead != -1){
            size--;
            for (int i = saveHead; i <tail ; i++) {
                array[i] = array[i+1];
            }
            array[tail] = null;
            tail--;
        }

        return (E)toReturn;
    }

    @Override
    public E removeFirst() {
      return poll();
    }

    @Override
    public E removeLast() {
        return pop();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return size;
    }

    @Override
    public void trimToSize() {

    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int startIndex=0;
            private int copyHead=head;


            @Override
            public boolean hasNext() {
                return startIndex < size;
            }

            @Override
            public E next() {
                startIndex++;
                return (E)array[copyHead++];
            }
        };
    }
    private Object[] grow(Object[] array) {
        int newSize = array.length*2;
        int curretSize = (this.tail-1) - this.head;
        int startingPoint = (newSize - curretSize)/2;
        Object[] newArray = new Object [newSize];
        if(this.head == -1){
            this.head = 0;
        }
        for (int i = 0; i <= curretSize; i++) {
            newArray[startingPoint++] = array[head++];

        }
        this.head = (newSize-curretSize)/2;
        this.tail = (newSize-curretSize)/2 +curretSize;
        return newArray;
    }
    private boolean ValidIndex(int index) {
        return index >= 0 && index < size;
    }
    private void addWithTail(int realInsertIndex, Object[] array) {
        for (int i = tail; i >= realInsertIndex; i--) {
            array[i] = array[i-1];
        }
    }

    private void addWithHead(int realInsertIndex, Object[] array) {
        for (int i = head; i < realInsertIndex; i++) {
            array[i] = array[i+1];
        }
    }
}
