package org.generics;

public class InformationShower<T extends Animal> {

  private final T animal;

  public InformationShower(T animal) {
    this.animal = animal;
  }

  public void showInformation() {
    System.out.println("Animal type: " + animal.getClass().getSimpleName());
    System.out.println("Food type: " + animal.type());
    animal.eat();
  }
}
