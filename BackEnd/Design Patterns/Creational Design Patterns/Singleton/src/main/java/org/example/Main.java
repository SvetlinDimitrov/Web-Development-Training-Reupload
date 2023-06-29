package org.example;

import org.example.threads.MultiTrading2;
import org.example.threads.MultiTreading;

public class Main {
    public static void main(String[] args) {
        MultiTreading multiTreading = new MultiTreading();
        MultiTrading2 multiTreading2 = new MultiTrading2();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(multiTreading);
            Thread thread2 = new Thread(multiTreading2);
            thread.start();
            thread2.start();
        }
    }
}