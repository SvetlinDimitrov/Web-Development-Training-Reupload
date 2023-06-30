package org.example;

public abstract class DecoratorTreasure implements Loot{

    protected static Integer price = 0;
    protected Loot loot;

    protected DecoratorTreasure(Loot loot) {
        this.loot = loot;
    }

    @Override
    public  void print(){
        System.out.println(getPriceOfTheLoot());
    }
}
