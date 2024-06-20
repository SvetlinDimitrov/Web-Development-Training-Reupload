package org.cvsc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 9, 10, 19, 23, 4, 5};

    //sorting array in ascending order
    System.out.println(Arrays.stream(arr)
        .sorted()
        .boxed()
        .map(String::valueOf)
        .collect(Collectors.joining(", "))
    );

    System.out.println("=====================================");
    //sorting array in descending order
    Comparator<Integer> reverseOrder = (a, b) -> b - a;

    System.out.println(Arrays.stream(arr)
        .boxed()
        .sorted(reverseOrder)
        .map(String::valueOf)
        .collect(Collectors.joining(", "))
    );
    System.out.println("=====================================");
    //sorting in a different way
    Comparator<Integer> oddNumbersFirstInDescOrder = (a, b) -> {
      if (a % 2 == 0 && b % 2 != 0) {
        return 1;
      } else if (a % 2 != 0 && b % 2 == 0) {
        return -1;
      } else {
        return b - a;
      }
    };

    System.out.println(Arrays.stream(arr)
        .boxed()
        .sorted(oddNumbersFirstInDescOrder)
        .map(String::valueOf)
        .collect(Collectors.joining(", "))
    );

    System.out.println("=====================================");
    //0) we can sort the person objects in on way using anonymous class that implements the Comparator interface
    Comparator<Person> comparator = new Comparator<>() {
      @Override
      public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
      }
    };

    Stream.of(new Person(23), new Person(45), new Person(34), new Person(12))
        .sorted(comparator)
        .forEach(System.out::println);

    System.out.println("=====================================");
    //sorting a list of objects
    //1) Object can implement the Comparable interface
    Stream.of(new Person(23), new Person(45), new Person(34), new Person(12))
        .sorted()
        .forEach(System.out::println);

    System.out.println("=====================================");

    //2) Using a Comparator
    Comparator<Person> personComparator = (p1, p2) -> p2.getAge() - p1.getAge();

    Stream.of(new Person(23), new Person(45), new Person(34), new Person(12))
        .sorted(personComparator)
        .forEach(System.out::println);

    System.out.println("=====================================");

    //3) We can just use the Comparator inside the sorted method
    // When using it we need to provide a function that extracts the value to be compared
    Stream.of(new Person(23), new Person(45), new Person(34), new Person(12))
        .sorted(Comparator.comparing(Person::getAge).reversed())
        .forEach(System.out::println);


    System.out.println("=====================================");

    //4) We can manually create a Compactor inside the sorted method
    //It will take a biFunction that will return an int
    Stream.of(new Person(23), new Person(45), new Person(34), new Person(12))
        .sorted((a , b) -> a.getAge() - b.getAge())
        .forEach(System.out::println);
  }
}