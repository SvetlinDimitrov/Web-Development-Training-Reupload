package org.example.entity;

public class Frog extends Animal{
    private final static String SUPER_POWER = "JUMP";

    @Override
    public void showPower() {
        System.out.println(SUPER_POWER);
    }
}
