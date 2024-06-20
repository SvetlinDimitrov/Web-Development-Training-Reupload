package org.trackerWebApp;

public class AbstractClassImp extends MyAbstractClass{

  protected int CONSTANT = 100;

  @Override
  public void myMethod() {
    super.myMethod();
    System.out.println("This is a method from AbstractClassImp");
  }
}
