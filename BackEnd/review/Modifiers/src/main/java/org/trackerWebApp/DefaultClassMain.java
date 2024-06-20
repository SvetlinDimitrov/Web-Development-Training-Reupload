package org.trackerWebApp;

class DefaultClassMain {
  public int x = 5;
  private int y = 10;
  protected int z = 15;
  int w = 20;

  /*
   * static: This keyword means that the variable belongs to the class, not instances of the class.
   * There's only one copy of this variable that's shared among all instances of the class.
   */
  public static int a = 25;

  /*
   * final: This keyword means that the value of this variable cannot be changed once it's initialized. It's a constant.
   */
  public final int b = 35;

  // This means that this value is a constant and cannot be changed
  public static final int CONSTANT = 50;

  /*
   * final: This keyword means that the method cannot be overridden by any subclass.
   * In other words, if a class extends this class, it cannot provide its own implementation of myFinalMethod().
   */
  public final void myFinalMethod() {
    System.out.println("This is a final method.");
  }

  public static void myStaticMethod() {
    System.out.println("This is a static method.");
  }

  /*
  * Abstract methods can only be declared inside an abstract class. But DefaultClassMain is not declared as abstract.
  * To fix this, you would need to declare DefaultClassMain as an abstract class:
  */
//  public abstract void myAbstractMethod();
}
