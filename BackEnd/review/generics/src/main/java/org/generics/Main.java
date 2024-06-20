package org.generics;

import java.util.List;

public class Main {
  public static void main(String[] args) {

    //the second param requested is of type Animal AND Creation , so this wont work as AnimalMeatGroup is not implementing Creation
    //multipleGenerics(AnimalMeatGroup.MAMMAL, AnimalGrassGroup.COW);

    //the second param requested is of type Animal AND Creation , so this will work as AnimalMeatGroup is implementing Creation
    multipleGenerics(AnimalMeatGroup.MAMMAL, AnimalMeatGroup.MAMMAL);
    multipleGenerics(AnimalGrassGroup.DEER, AnimalMeatGroup.REPTILE);
  }

  // for the first generic type, we are using the Animal interface
  // for the second generic type, we are using the Animal AND Creation interface
  private static <T extends Animal, M extends Animal & Creation> void multipleGenerics(T animal, M animal2) {
    InformationShower<T> animalGroupInfo = new InformationShower<>(animal);
    animalGroupInfo.showInformation();

    InformationShower<M> animalGroupInfo2 = new InformationShower<>(animal2);
    animalGroupInfo2.showInformation();
  }

  /*
  The method print is a generic method that accepts a List of any type that extends Animal.
  The ? extends Animal is a bounded wildcard that restricts the unknown type to be either
  Animal or a subclass of Animal.
  */
  private static void print(List<? extends Animal> elements) {
    elements.forEach(Animal::eat);
  }

  /*
  The method print2 is a generic method that accepts a List of any type that is a superclass of Animal.
   The ? super Animal is a bounded wildcard that restricts the unknown type to be either
   Animal or a superclass of Animal.

   This is useful when you want to ensure that the list can accept elements of type Animal or
   any of its subclasses. For example, if you have a List<Object>, you can pass it to this method
   because Object is a superclass of Animal.
  */
  private static void print2(List<? super Animal> animals) {
    for (Object obj : animals) {
      // You would need to cast obj to Animal before calling any Animal methods
      Animal animal = (Animal) obj;
      animal.eat();
    }
  }
}