package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class DataRaceAtomic {
    public static AtomicInteger counts = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                counts.addAndGet(1);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                counts.addAndGet(1);
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
