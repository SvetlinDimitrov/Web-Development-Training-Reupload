package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker extends Thread {
    public static Integer count1 = 0 , count2 = 0;
    static Lock lock = new ReentrantLock();

    private void incrementCount1 () {
        lock.lock();
        count1++;
        lock.unlock();
    }

    private void incrementCount2 () {
        lock.lock();
        count2++;
        lock.unlock();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000; i++) {
            incrementCount1();
            incrementCount2();
        }
    }
}
public class ReentrantLook {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Worker();
        Thread thread2 = new Worker();

        thread2.start();
        thread.start();

        thread2.join();
        thread.join();

        System.out.println(Worker.count1);
        System.out.println(Worker.count2);
    }
}