package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Adapter(new MultiplyCalc("2" , "3")).insaneCalculate());
    }
}