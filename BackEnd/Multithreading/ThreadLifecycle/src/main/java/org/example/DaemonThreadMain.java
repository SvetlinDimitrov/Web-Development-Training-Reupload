package org.example;

class Current implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Current Sparks");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class DaemonThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Thread current = new Thread(new Current());
        current.setDaemon(true);
        System.out.println("Power On");
        current.start();
        Thread.sleep(5000);
        System.out.println("Power Off");
    }
}
