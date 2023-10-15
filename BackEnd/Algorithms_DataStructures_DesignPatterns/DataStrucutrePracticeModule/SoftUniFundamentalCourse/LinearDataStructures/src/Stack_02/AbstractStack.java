package Stack_02;

public interface AbstractStack<E> extends Iterable<E> {
    void push(E element);
    E pop();
    E peek();
    int size();
    boolean isEmpty();
}
