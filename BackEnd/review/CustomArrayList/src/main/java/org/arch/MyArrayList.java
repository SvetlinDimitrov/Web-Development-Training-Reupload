package org.arch;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {

  private T[] array;
  private int size;
  private static final int DEFAULT_SIZE = 10;

  public MyArrayList() {
    array = createNewArray(DEFAULT_SIZE);
    size = 0;
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
  public boolean contains(Object o) {
    return indexOf(o) != -1;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public T next() {
        return array[index++];
      }
    };
  }

  @Override
  public Object[] toArray() {
    Object[] objects = new Object[size];
    System.arraycopy(array, 0, objects, 0, size);
    return objects;
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    int matches = 0;

    for (T1 t : a) {
      if (contains(t)) {
        matches++;
      }
    }

    if (matches == a.length) {
      return a;
    }
    int initIndex = 0;
    T1[] newArray = (T1[]) new Object[matches];

    for (T1 t : a) {
      if (contains(t)) {
        newArray[initIndex] = t;
        initIndex++;
      }
    }

    return newArray;
  }

  @Override
  public boolean add(T t) {
    if (size == array.length) {
      array = Arrays.copyOf(array, array.length * 2);
    }

    array[size] = t;
    size++;
    return true;
  }

  @Override
  public boolean remove(Object o) {
    int index = indexOf(o);
    if (index == -1) {
      return false;
    }
    size--;
    T[] newArray = createNewArray(size);

    System.arraycopy(array, 0, newArray, 0, index);
    System.arraycopy(array, index + 1, newArray, index, size - index);

    array = newArray;

    return true;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object t : c) {
      if (!contains(t)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    for (T t : c) {
      add(t);
    }
    return true;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    for (T t : c) {
      add(index, t);
      index++;
    }
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    for (Object t : c) {
      remove(t);
    }
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    for (int i = 0; i < size; i++) {
      if (!c.contains(array[i])) {
        remove(array[i]);
      }
    }
    return false;
  }

  @Override
  public void clear() {
    array = createNewArray(DEFAULT_SIZE);
    size = 0;
  }

  @Override
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return array[index];
  }

  @Override
  public T set(int index, T element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    T oldElement = array[index];
    array[index] = element;
    return oldElement;
  }

  @Override
  public void add(int index, T element) {
    size++;
    T[] newArray = createNewArray(size);
    System.arraycopy(array, 0, newArray, 0, index);
    newArray[index] = element;
    System.arraycopy(array, index, newArray, index + 1, size - index);
    array = newArray;
  }

  @Override
  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    size--;
    T[] newArray = createNewArray(size);
    System.arraycopy(array, 0, newArray, 0, index);
    System.arraycopy(array, index + 1, newArray, index, size - index);
    T removedElement = array[index];
    array = newArray;
    return removedElement;
  }

  @Override
  public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
      if (array[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    for (int i = size - 1; i >= 0; i--) {
      if (array[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public ListIterator<T> listIterator() {
    return null;
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    return null;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException();
    }
    T[] newArray = createNewArray(toIndex - fromIndex);
    System.arraycopy(array, fromIndex, newArray, 0, toIndex - fromIndex);
    return Arrays.asList(newArray);
  }

  @Override
  public String toString() {
    T[] newArray = createNewArray(size);
    System.arraycopy(array, 0, newArray, 0, size);

    return Arrays.toString(newArray);
  }

  private T[] createNewArray(int size) {
    return (T[]) new Object[size];
  }
}
