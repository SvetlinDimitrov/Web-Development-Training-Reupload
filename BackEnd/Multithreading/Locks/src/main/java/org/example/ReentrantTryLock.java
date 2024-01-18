package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NormalReentrantLock extends Thread {
    public static Integer count1 = 0;
    private int pointsToAdd = 0;
    static Lock lock = new ReentrantLock();

    private void incrementCount1() {
        while(count1 <= 1_000_000){

            if (pointsToAdd != 0) {
                lock.lock();
                System.out.println("NormalReentrantLock class points added: " + pointsToAdd);
                count1 = count1 + pointsToAdd;
                pointsToAdd = 0;
                lock.unlock();
            }else{
                pointsToAdd++;
            }
        }
    }

    @Override
    public void run() {
        incrementCount1();
    }
}
class TryLockReentrantLock extends Thread {
    public static Integer count1 = 0;
    private int pointsToAdd = 0;
    static Lock lock = new ReentrantLock();

    private void incrementCount1() {
        while(count1 <= 1_000_000){

            if (pointsToAdd != 0 && lock.tryLock()) {
                System.out.println("TryLockReentrantLock class points added " + pointsToAdd);
                count1 = count1 + pointsToAdd;
                pointsToAdd = 0;
                lock.unlock();
            }else{
                pointsToAdd++;
            }
        }
    }

    @Override
    public void run() {
        incrementCount1();
    }
}

public class ReentrantTryLock {
    public static void main(String[] args) throws InterruptedException {
        String results = withBlockingEffect();
        String results2 = withoutBlockingEffect();
        System.out.println(results);
        System.out.println(results2);
    }

    private static String withoutBlockingEffect() throws InterruptedException {
        Thread thread = new TryLockReentrantLock();
        Thread thread2 = new TryLockReentrantLock();
        long start = System.currentTimeMillis();
        thread2.start();
        thread.start();

        thread2.join();
        thread.join();
        long end = System.currentTimeMillis();
        return  String.format("TryLockReentrantLock finish the program for : %.2f seconds", (end - start) / 1000.0);
    }

    private static String withBlockingEffect() throws InterruptedException {
        Thread thread = new NormalReentrantLock();
        Thread thread2 = new NormalReentrantLock();
        long start = System.currentTimeMillis();
        thread2.start();
        thread.start();

        thread2.join();
        thread.join();
        long end = System.currentTimeMillis();
        return  String.format("NormalReentrantLock finish the program for : %.2f seconds", (end - start) / 1000.0);
    }
}
