package org.example.entity;

public class Lion extends Animal{
    private final static String COLOR = "YELLOW";

    @Override
    public void showPower() {
        System.out.println(COLOR);
    }
}
