package org.trackerWebApp;

public abstract class MyAbstractClass {

  protected int CONSTANT = 50;

  public MyAbstractClass() {
    System.out.println("This is a constructor from AbstractClassImp");
  }

  public void myMethod() {
    System.out.println("This is a method from MyAbstractClass");
  }
}
