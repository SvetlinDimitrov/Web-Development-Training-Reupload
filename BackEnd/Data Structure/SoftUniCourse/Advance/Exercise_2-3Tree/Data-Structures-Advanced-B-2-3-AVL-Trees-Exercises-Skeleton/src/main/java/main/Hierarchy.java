package main;

import java.util.*;
import java.util.stream.Collectors;

public class Hierarchy<T> implements IHierarchy<T> {
    Helper<T> root;
    Map<T, Helper<T>> data = new LinkedHashMap<>();


    public Hierarchy(T element) {
        this.root = new Helper<>(element);
        data.put(element, root);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public void add(T element, T child) {
        if (data.containsKey(element) && !data.containsKey(child)) {
            Helper<T> toAdd = new Helper<>(child);
            data.get(element).child.add(toAdd);
            toAdd.parent = data.get(element);
            data.put(child, toAdd);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void remove(T element) {
        if (data.containsKey(element) && data.get(element).parent == null) {
            throw new IllegalStateException();
        }
        if(!data.containsKey(element)){
            throw new IllegalArgumentException();
        }
        Helper<T> parent = data.get(element).parent;
        Helper<T> elementToRemove = data.get(element);

        if (elementToRemove.child.isEmpty()) {
            data.remove(element);
            parent.child.remove(elementToRemove);
        } else {
            ArrayList<Helper<T>> childrens = elementToRemove.child;
            for (Helper<T> children : childrens) {
                children.parent = parent;
            }
            parent.child.addAll(childrens);
            data.remove(element);
            parent.child.remove(elementToRemove);

        }
    }

    @Override
    public Iterable<T> getChildren(T element) {
        return data.get(element).child.stream().map(e -> e.element).collect(Collectors.toList());
    }

    @Override
    public T getParent(T element) {
        if (data.containsKey(element)) {
            if (data.get(element).parent == null) {
                return null;
            }
            return data.get(element).parent.element;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean contains(T element) {
        return data.containsKey(element);
    }

    @Override
    public Iterable<T> getCommonElements(IHierarchy<T> other) {
        ArrayList<T> list = new ArrayList<>();

        for (Helper<T> value : data.values()) {
            if(other.contains(value.element)){
                list.add(value.element);
            }
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        ArrayDeque<Helper<T>> deque = new ArrayDeque<>();
        deque.offer(root);

        return new Iterator<T>() {


            @Override
            public boolean hasNext() {
                return !deque.isEmpty();
            }

            @Override
            public T next() {
                Helper<T> parent = deque.poll();
                deque.addAll(parent.child);
                return parent.element;
            }
        };
    }
}
