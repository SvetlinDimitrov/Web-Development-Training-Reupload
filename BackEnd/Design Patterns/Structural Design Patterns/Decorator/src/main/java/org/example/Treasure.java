package org.example;

public class Treasure implements Loot{
    private static final Integer price = 0;
    @Override
    public Integer getPriceOfTheLoot() {
        return price;
    }

    @Override
    public void print() {
        System.out.println(getPriceOfTheLoot());
    }
}
