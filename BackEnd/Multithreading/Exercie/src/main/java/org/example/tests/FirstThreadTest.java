package org.example.tests;

import org.example.runables.FirstThread;

public class FirstThreadTest {
    public static void main(String[] args) throws InterruptedException {
        FirstThread thread1 = new FirstThread();
        FirstThread thread2 = new FirstThread();
        FirstThread thread3 = new FirstThread();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
