package org.example;

import java.util.Stack;

public class MementoExample {

    static class Calculator {
        private int number;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public Memento save() {
            return new Memento(number);
        }

        public void undo(Memento memento) {
            this.number = memento.number();
        }
    }

    record Memento(int number) {
    }

    static class History {
        private final Stack<Memento> stack = new Stack<>();

        public void save(Memento memento) {
            stack.push(memento);
        }

        public Memento undo() {
            if (stack.isEmpty()) {
                return null;
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        History history = new History();

        Calculator calculator = new Calculator();
        calculator.setNumber(50);
        System.out.println(calculator.getNumber());

        history.save(calculator.save());
        calculator.setNumber(25);
        System.out.println(calculator.getNumber());

        calculator.undo(history.undo());
        System.out.println(calculator.getNumber());
    }
}
