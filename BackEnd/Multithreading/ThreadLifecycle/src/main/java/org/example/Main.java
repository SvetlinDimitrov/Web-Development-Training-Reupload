package org.example;

class Worker extends Thread {
    public void run () {
        System.out.println("Worker is starting his job. Worker state :" + this.getState());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Worker finish his job. Worker state :" + this.getState());
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Director start working");
        System.out.println("He ask for help");

        Worker worker = new Worker();
        System.out.println("Worker just come state :" + worker.getState());
        worker.start();

        Thread.sleep(500);
        System.out.println("Director finishes his job");
        System.out.println("Worker state :" + worker.getState());

        worker.join();
        System.out.println("Worker state :" + worker.getState());

        System.out.println("Everything is done");
    }
}