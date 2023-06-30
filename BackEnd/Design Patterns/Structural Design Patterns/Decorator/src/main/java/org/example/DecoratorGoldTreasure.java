package org.example;

public class DecoratorGoldTreasure extends DecoratorTreasure {
    private final static Integer price = 50;
    public DecoratorGoldTreasure(Loot loot) {
        super(loot);
    }

    @Override
    public Integer getPriceOfTheLoot() {
        return loot.getPriceOfTheLoot() + price;
    }
}
