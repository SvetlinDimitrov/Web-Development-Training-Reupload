package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExercise {
    static class Worker extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is doing a job");
        }
    }

    public static void main(String[] args) {

        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(processors);
        for (int i = 0; i < 100; i++) {
            pool.submit(new Worker());
        }
        pool.shutdown();

    }
}