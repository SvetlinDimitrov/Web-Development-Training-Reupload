package org.Interface;

public interface Animal {

  /*
   * The public keyword means that this method is accessible from any class.
   *
   * The abstract keyword means that this method is declared but not implemented.
   * In other words, it doesn't have a body in the Animal interface.
   * Any class that implements the Animal interface will need to provide an implementation for this eat method.*/
  public abstract void eat();
  /*
   * In Java, abstract and private cannot be used together as modifiers for a method.
   * The abstract modifier means that the method doesn't have a body and must be implemented in a subclass.
   * On the other hand, private means the method is only accessible within the same class and cannot be accessed from subclasses.
   * Therefore, a private abstract method would never be able to be implemented, which contradicts the rules of Java*/
//  private abstract void sleep();
  /*
   * In Java, the protected access modifier is not allowed in an interface.
   * This is because all methods in an interface are implicitly public, as they are meant to be implemented
   * by any class that uses the interface.
   *
   * The protected access modifier is typically used in a class context,
   * where it makes a member accessible within the same package and also by subclasses of the class in other packages.
   * However, in an interface, there's no sense of 'package' or 'subclass' for the methods, as they are meant to be public contracts
   * that any class can implement, regardless of package or inheritance hierarchy.*/
//  protected abstract void sleep();
  /*
   * In Java, the abstract and final modifiers cannot be used together for a method.
   * The abstract modifier indicates that a method doesn't have a body and must be implemented by a subclass.
   *
   * On the other hand, final means that the method cannot be overridden in a subclass.
   *
   * Therefore, a public abstract final method would contradict itself - it would need to be implemented in a subclass due
   * to being abstract, but it could not be overridden in a subclass due to being final.
   * This is why you're seeing an error.*/
//  public abstract final void sleep();
  /*
   * In Java, a method cannot be both default and abstract.
   *
   * The default keyword is used to provide a default implementation of a method in an interface.
   * This means that any class implementing the interface will inherit this method unless the class chooses to override it.
   *
   * On the other hand, the abstract keyword is used to declare a method without providing an implementation.
   * This means that any class implementing the interface must provide an implementation for this method.
   *
   * Therefore, a method cannot be both default (providing a default implementation) and abstract (requiring an implementation).
   * You should choose one or the other based on your needs.*/
//public default abstract void sleep();

  /*
   * The default keyword is used to provide a default implementation of a method in an interface.
   * This means that any class implementing the interface will inherit this method unless the class chooses to override it.*/
  public default void sleep() throws CloneNotSupportedException {
    System.out.println("Animal is sleeping");
  }

  static void sleep2(){
    System.out.println("asdasdasd");
  }

}
