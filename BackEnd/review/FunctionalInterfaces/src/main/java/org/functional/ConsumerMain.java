package org.functional;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerMain {
  public static void main(String[] args) {

    /*
      In Java, a Consumer is a functional interface that represents an operation that accepts a single input argument and returns no result.
      Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
      This makes it extremely useful in certain scenarios, especially when working with Java Streams and lambda expressions.
    */
    Consumer<String> print = System.out::println;
    print.accept("Hello World");

    // Chaining consumers
    Consumer<String> secondPrint = (a) -> System.out.println("Second print: " + a);
    print.andThen(secondPrint).accept("Hello World");

    String[] strings = {"Hello", "World", "Java"};
    Arrays.stream(strings)
        .forEach(print);

    Stream.of("Hello", "World", "Java")
        .forEach(print);

  }
}
