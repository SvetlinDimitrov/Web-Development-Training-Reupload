package org.generics;

public enum AnimalGrassGroup implements Animal {
  RABBIT(FoodType.GRASS),
  COW(FoodType.GRASS),
  DEER(FoodType.GRASS);

  public final FoodType type;

  AnimalGrassGroup(FoodType type) {
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
