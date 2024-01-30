package org.example;

public class StateExample {

    static class Person {
        private State state;

        public Person(State state) {
            this.state = state;
        }

        public void showMood() {
            state.showMood();
        }

        public void changeState(State state) {
            this.state = state;
        }
    }

    interface State {
        void showMood();
    }

    static class AngryMood implements State {

        @Override
        public void showMood() {
            System.out.println("i am so angry");
        }
    }

    static class SadMood implements State {

        @Override
        public void showMood() {
            System.out.println("I am so sad");
        }
    }

    public static void main(String[] args) {
        Person person = new Person(new SadMood());
        person.showMood();
        person.changeState(new AngryMood());
        person.showMood();
    }
}
