package org.example.tests;

import org.example.runables.SecondThread;

public class SecondThreadTest {
    public static void main(String[] args) {
        Thread test1 = new Thread(new SecondThread());
        Thread test2 = new Thread(new SecondThread());
        Thread test3 = new Thread(new SecondThread());

        test1.start();
        test2.start();
        test3.start();
    }
}
