package org.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateMain {
  public static void main(String[] args) {
    /*
    In Java, a Predicate is a functional interface that represents a boolean-valued function of one argument.
    It is often used when you need to define a lambda that tests a condition (that is, a function that returns a boolean).

    The Predicate interface has a single method, test(T t), which returns true if the condition is met and false otherwise.
    */

    Predicate<Integer> isPositive = i -> i > 0;
    System.out.println(isPositive.test(5));

    // Used to chain multiple predicates
    Predicate<Integer> isPositiveAndOdd = isPositive.and((a) -> a % 2 != 0);
    System.out.println(isPositiveAndOdd.test(5));

    // Used to reverse the result of a predicate
    Predicate<Integer> negate = isPositiveAndOdd.negate();
    System.out.println(negate.test(5));

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    Arrays.stream(numbers)
        .filter(((IntPredicate) a -> a % 2 == 0).and(a -> a > 5))
        .forEach(System.out::println);

    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter(isPositiveAndOdd.and(a -> a > 5))
        .forEach(System.out::println);

  }
}
