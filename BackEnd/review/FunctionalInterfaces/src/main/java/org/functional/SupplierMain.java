package org.functional;

import java.util.function.Supplier;

public class SupplierMain {

  /*
  In Java, a Supplier is a functional interface that represents a supplier of results.
  It has a single method, get(), which takes no arguments and returns a result.

  The Supplier interface is often used when you need a lambda to generate or supply values.
  It can be particularly useful when used in conjunction with other functional interfaces or methods that require a Supplier.
  */

  public static void main(String[] args) {
    // A simple example of a Supplier
    Supplier<String> supplier = () -> "Hello, World!";
    
    System.out.println(supplier.get());
  }
}
