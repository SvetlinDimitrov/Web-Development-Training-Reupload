package org.lambdas;

public class Main {
  public static void main(String[] args) {

    /*
    Lambda expressions, also known as lambdas, are a feature in Java that were introduced in Java 8.
    They provide a clear and concise way to represent one method interface using an expression.
    Lambdas are used primarily to define inline implementation of a functional interface, i.e., an interface
    with a single method only.

    Here are some key points about lambdas in Java:

    Syntax: The lambda expression syntax is: (argument) -> (body).
    For example, (a, b) -> a + b is a lambda expression that takes two parameters and returns their sum.

    Functional Interfaces: Lambdas are instances of functional interfaces. A functional interface is an
    interface with just one abstract method (excluding the methods from Object class).
    Java 8 introduced an annotation @FunctionalInterface that can be used to ensure an interface meets
    the requirements of a functional interface. (?)

    Method References: Lambdas can be used with method references, which allow you to reference methods
    directly using their names. There are four types of method references: static method references,
    instance method references of a particular object, instance method references of an arbitrary object
    of a particular type, and constructor references.

    Use with Streams: Lambdas are commonly used with the Stream API in Java 8 and later, which
    supports functional-style operations on streams of elements, such as map-reduce transformations.

    No Access to Local Variables: Lambdas can't access non-final local variables in the enclosing scope.

    Benefits: Lambdas can make your code more readable and less verbose.
    They also enable functional programming and the use of powerful functions provided by the Stream API.
    * */

    Runnable r = () -> System.out.println("Hello, Lambda!");
    r.run();

    //1) Creating a new class that implements the Shootable interface.
    Shootable s = new Gun();
    s.fire();

    //2) Creating a inner class
    Shootable s2 = new Shootable() {
      @Override
      public void fire() {
        System.out.println("Bang! from the inner class.");
      }
    };

    //3) creating a lambda expression
    Shootable s3 = () -> System.out.println("Bang! from the lambda expression.");

    //In the first way we want to use classes when we are going to re-use the class and we will have more then just one interface
    //In the second way we want to use inner classes when we are going to use the class only once and we don't want to create a new class
    //In the third way we want to use lambda expressions when we are going to use the class only once and there is a functional interface

  }
}