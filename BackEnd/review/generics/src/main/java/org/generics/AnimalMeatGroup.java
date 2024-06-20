package org.generics;

public enum AnimalMeatGroup implements Animal, Creation {

  MAMMAL(FoodType.MEAT),
  REPTILE(FoodType.MEAT);

  public final FoodType type;

  AnimalMeatGroup(FoodType type) {
    this.type = type;
  }

  @Override
  public void eat() {
    System.out.println("Eating " + type);
  }

  @Override
  public String type() {
    return type.toString();
  }

}
