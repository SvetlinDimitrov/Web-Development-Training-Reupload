package org.functional;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Stream;

public class FunctionMain {
  public static void main(String[] args) {

    // Function is a functional interface that takes one argument and returns a result.
    // The first argument is the type of the input to the function, and the second argument is the type of the result.
    Function<Integer, Integer> add10ToNumber = (a) -> a + 10;
    System.out.println(add10ToNumber.apply(10));

    // Compose is a default method in the Function interface that allows you to compose two functions together.
    // The compose method takes a function. The function passed to the compose method is executed first.
    // The first argument of the functions that is composed does not matter but the second argument should be a type that the first function can accept.
    Function<String, Integer> compose = add10ToNumber.compose((a) -> Integer.parseInt(a) + 2);
    System.out.println(compose.apply("10"));

    // andThen is a default method in the Function interface that takes a functions as a param
    // The function is executed after the function that is calling the andThen method.
    // Witch means the first param of the second functions should be the output of the first function. And the second param can be anything.
    String apply = compose.andThen((a) -> "Hello World " + a).apply("10");
    System.out.println(apply);

    //Returns the same value that is passed to it
    Function<Integer, Integer> something = Function.identity();
    System.out.println(something.apply(10));

    /*
    The IntFunction<R> interface is used when you know that the input to the function will be an integer primitive.
    This can be particularly useful when you're working with streams of integers or arrays of integers,
    as it can help to avoid the overhead of auto-boxing and unboxing.
    * */
    IntUnaryOperator intFunction = (a) -> a + 10;
    int[] nums = {2, 13, 1, 9};
    Arrays.stream(nums)
        .sorted()
        .map(intFunction)
        .forEach(System.out::println);


    Integer reduce = Stream.of(1, 2, 3, 4, 6, 7, 8, 9, 10)
        .reduce(0, Integer::sum);

    System.out.println(reduce);
  }
}