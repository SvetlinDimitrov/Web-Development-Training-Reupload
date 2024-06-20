package org.trackerWebApp;

public class ChildClass extends DefaultClassMain {


  /*
  This will throw and error because the method is final and cannot be overridden
  */
//  @Override
//  public void myFinalMethod() {
//    System.out.println("This is a final method in ChildClass.");
//  }


  /*
  In Java, when we talk about overriding a method,
  we usually refer to a situation where a subclass provides its own implementation of a method that is already provided by its parent class.
  This is possible because of a feature called dynamic binding, where the Java Virtual Machine (JVM) decides at runtime which
  method to call based on the actual type of the object.

  However, static methods are a bit different. They belong to the class itself,
  not to any instance of the class. When you call a static method, the JVM doesn't need to look at the actual type of the object -
  it just calls the method that is associated with the class. This is known as static binding, and it happens at compile time,
  not at runtime.  So, when you have a static method in a parent class and a method with the same name in a child class,
  the child class method doesn't override the parent class method in the traditional sense.
  * */
//  @Override
  public static void myStaticMethod() {
    System.out.println("This is a static method in ChildClass.");
  }
}
