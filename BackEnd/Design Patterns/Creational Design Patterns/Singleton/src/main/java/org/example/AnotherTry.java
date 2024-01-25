package org.example;

public class AnotherTry {
    private static AnotherTry INSTANCE;
    private AnotherTry () {};

    public static synchronized AnotherTry getInstance(){
        if(INSTANCE == null){
            INSTANCE = new AnotherTry();
        }
        return INSTANCE;
    }

    public void printHelloWorld (){
        System.out.println("Hello World");
    }
}
