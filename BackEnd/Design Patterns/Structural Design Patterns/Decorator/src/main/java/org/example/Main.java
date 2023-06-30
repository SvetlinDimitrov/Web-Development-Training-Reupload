package org.example;

public class Main {
    public static void main(String[] args) {
        Loot loot =
                new DecoratorGoldTreasure(
                        new DecoratorSilverTreasure(
                                new DecoratorSilverTreasure(
                                        new DecoratorSilverTreasure(
                                                new Treasure()))));
        loot.print();
    }
}