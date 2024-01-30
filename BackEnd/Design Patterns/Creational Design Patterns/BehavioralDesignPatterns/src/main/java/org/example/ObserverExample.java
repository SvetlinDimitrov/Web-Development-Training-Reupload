package org.example;

import java.util.ArrayList;
import java.util.List;

public class ObserverExample {
    interface Subscriber {
        void notifySub();
    }

    static class Person1 implements Subscriber {

        @Override
        public void notifySub() {
            System.out.println("Person1 get the message");
        }
    }

    static class Person2 implements Subscriber {

        @Override
        public void notifySub() {
            System.out.println("Person2 got the message");
        }
    }

    static class Notifier {
        private final List<Subscriber> subscribers = new ArrayList<>();

        public void addSubs(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        public void removeSubs(Subscriber subscriber) {
            subscribers.remove(subscriber);
        }

        public void notifyAllSubs() {
            System.out.println("Spam to all");
            subscribers.forEach(Subscriber::notifySub);
        }
    }

    public static void main(String[] args) {
        Person1 person1 = new Person1();
        Person2 person2 = new Person2();

        Notifier notifier = new Notifier();
        notifier.addSubs(person1);
        notifier.addSubs(person2);
        notifier.notifyAllSubs();
    }
}
