package org.example;

public class DataRaceSyncMethod {
    public static Integer counts = 0;

    private static synchronized void increaseCount() {
        counts++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                increaseCount();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                increaseCount();
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
