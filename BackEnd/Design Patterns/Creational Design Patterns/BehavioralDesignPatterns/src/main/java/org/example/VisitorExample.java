package org.example;

public class VisitorExample {

    interface Visitor {
        void cookPerson1();

        void cookPerson2();
    }

    ;

    interface Person {
        void cook();

        void accept(Visitor visitor);
    }

    static class Person1 implements Person {

        @Override
        public void cook() {
            System.out.println("Cooking only with Oil");
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.cookPerson1();
        }
    }

    static class Person2 implements Person {

        @Override
        public void cook() {
            System.out.println("Cooking with something wrong");
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.cookPerson2();
        }
    }

    static class HealthyVisitor implements Visitor {

        @Override
        public void cookPerson1() {
            System.out.println("Cooking only with olive oil");
        }

        @Override
        public void cookPerson2() {
            System.out.println("Cooking only with olive oil");

        }
    }

    public static void main(String[] args) {
        Person1 person1 = new Person1();
        Person2 person2 = new Person2();

        Visitor visitor = new HealthyVisitor();
        person2.cook();
        person2.accept(visitor);
        System.out.println("----------------------------------------------------------");
        person1.cook();
        person1.accept(visitor);
    }
}
