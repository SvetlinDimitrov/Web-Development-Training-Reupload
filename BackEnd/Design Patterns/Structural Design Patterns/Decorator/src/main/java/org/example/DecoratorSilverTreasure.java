package org.example;

public class DecoratorSilverTreasure extends DecoratorTreasure{
    private final static Integer price = 20;
    protected DecoratorSilverTreasure(Loot loot) {
        super(loot);
    }

    @Override
    public Integer getPriceOfTheLoot() {
        return price + loot.getPriceOfTheLoot();
    }
}
