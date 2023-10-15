package implementations;

import interfaces.List;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private int size = 4;
    private int index;
    Object [] arr;

    public ArrayList() {
        size = 4;
        arr = new Object[size];
        index =0;
    }

    @Override
    public boolean add(E element) {
        if(index > size-1){
            arr = grow(arr);
            arr[index] = element;
        }else{
            arr[index] = element;
        }
        index++;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if(isInTheScope(index)){
            arr = AddingToRight(arr , index ,element);
            this.index++;
            return true;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }



    @Override
    public E get(int index) {
        if(isInTheScope(index)){
            return (E) arr[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E set(int index, E element) {
        if(isInTheScope(index)){
            Object prev = arr[index];
            arr[index] = element;
            return (E) prev;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E remove(int index) {
        if(isInTheScope(index) && arr[index] !=null) {
            Object toReturn = arr[index];
            arr = RemovingToRight(arr ,index);
            this.index--;
            return (E) toReturn;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public int indexOf(E element) {
        if(isInTheScope(index)) {
            for (int i = 0; i < index; i++) {
                if(arr[i].equals(element)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < index; i++) {
            if(arr[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter != index;
            }

            @Override
            public E next() {
                return (E) arr[counter++];
            }
        };
    }

    private Object[] grow(Object[] arr) {
        size *= 2;
        Object [] arrCopy = new Object[size];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        return arrCopy;
    }
    private Object[] AddingToRight(Object[] arr, int index, E element) {
        size+=1;
        Object [] arrCopy = new Object[size];
        for (int i = 0; i < index; i++) {
            arrCopy[i] = arr[i];
        }
        arrCopy[index] = element;
        for (int i = index; i <arr.length ; i++) {
            arrCopy[i+1] = arr[i];
        }
        return arrCopy;
    }
    private boolean isInTheScope(int index) {
        return index <= this.index && index >= 0;
    }
    private Object[] RemovingToRight(Object[] arr, int index) {
        size-=1;
        Object[] arrCopy = new Object[size];
        for (int i = 0; i < index; i++) {
            arrCopy[i] = arr[i];
        }
        for (int i = index+1; i <arr.length ; i++) {
            arrCopy[i-1] = arr[i];
        }
        return arrCopy;
    }
}
