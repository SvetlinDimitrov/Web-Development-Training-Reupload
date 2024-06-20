package org.Interface;

public class Person implements Animal{

  @Override
  public void eat() {
    System.out.println("Person is eating");
  }

  @Override
  public void sleep() throws CloneNotSupportedException {
    /*
    * In Java, when a class implements an interface that has a default method,
    *  it can choose to override that method with its own implementation,
    * or it can choose to use the default implementation provided by the interface.
    * If the class chooses to override the default method but still wants to use the default implementation in some way,
    * it can do so using the super keyword followed by the method name.*/
    Animal.super.sleep();
    System.out.println("Animal is sleeping2");
  }

}
