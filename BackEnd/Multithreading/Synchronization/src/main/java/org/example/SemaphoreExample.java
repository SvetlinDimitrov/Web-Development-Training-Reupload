package org.example;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 5; i++) {
            new Thread(new Worker(i, semaphore)).start();
        }
    }

    static class Worker implements Runnable {
        private final int id;
        private final Semaphore semaphore;

        public Worker(int id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                System.out.println("Worker " + id + " is trying to acquire a permit.");
                semaphore.acquire();
                System.out.println("Worker " + id + " has acquired a permit.");

                Thread.sleep(2000);

                System.out.println("Worker " + id + " is releasing the permit.");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
