package org.example;


class CPUWaster extends Thread {
    public void run (){
        while(true){}
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Process id :" + ProcessHandle.current().pid());
        System.out.println("Active threads :" + Thread.activeCount());
        System.out.println("Available threads:" + (12 - Thread.activeCount()));

        for (int i = 0; i < 6; i++) {
            CPUWaster cpuWaster = new CPUWaster();
            cpuWaster.start();
        }

        System.out.println("Process id :" + ProcessHandle.current().pid());
        System.out.println("Active threads :" + Thread.activeCount());
        System.out.println("Available threads:" + (12 - Thread.activeCount()));
    }
}