package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataRaceLock {
    public static Integer counts = 0;
    public static Lock countLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                countLock.lock();
                counts++;
                countLock.unlock();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                countLock.lock();
                counts++;
                countLock.unlock();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Expected count :" + 20_000_000);
        System.out.println("Actual count :" + counts);
    }
}
