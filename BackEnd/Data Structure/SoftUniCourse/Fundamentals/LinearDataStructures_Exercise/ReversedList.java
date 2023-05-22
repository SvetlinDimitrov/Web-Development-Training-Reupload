package implementations;

import javax.lang.model.element.Element;
import java.util.Iterator;

public class ReversedList<E> implements Iterable {

    private  Object [] elements;
    private int size ;

    public ReversedList() {
        elements = new Object[2];
        size=0;
    }

    public void add(E element){
        if(size == 0){
            elements[0] = element;
        }else{
            if(size == elements.length){
                elements = grow(elements);
                elements[0] = element;
            }else{
                for (int i = size; i > 0; i--) {
                    elements[i] = elements[i-1];
                }
                elements[0] = element;
            }
        }
        size++;
    }
    public int size(){
        return size;
    }
    public int capacity(){
        return elements.length;
    }

    public E get(int index){
        if(ValidIndex(index)){
            return (E) elements[index];
        }
        throw new IndexOutOfBoundsException();
    }
    public E removeAt(int index){
        if(ValidIndex(index)){
            E element = (E) elements[index];
            for (int i = index; i < size; i++) {
                elements[i] = elements[i+1];
            }
            size--;
            elements[size] = null;
            return element;
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index=0;

            @Override
            public boolean hasNext() {
                return index < size-1;
            }

            @Override
            public Object next() {
                index++;
                E element = (E) elements[index];
                return element;
            }
        };
    }
    private Object[] grow(Object[] elements) {
        Object[] copyElements = new Object[size*2];
        for (int i = 1; i <= elements.length; i++) {
            copyElements[i] = elements[i-1];
        }
        return copyElements;
    }
    private boolean ValidIndex(int index) {
        return index >= 0 && index <= size-1 ;
    }
}
