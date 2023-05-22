package main;

import java.awt.*;
import java.util.ArrayList;

public class Helper<T> {
    T element;
    Helper<T> parent;
    ArrayList<Helper<T>> child;

    public Helper(T element) {
        this.element = element;
        this.parent = null;
        this.child = new ArrayList<>();
    }

    public T getElement() {
        return element;
    }

    public Helper<T> getParent() {
        return parent;
    }
}
