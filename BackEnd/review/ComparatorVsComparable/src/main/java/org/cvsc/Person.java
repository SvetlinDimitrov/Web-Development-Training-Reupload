package org.cvsc;

public class Person implements Comparable<Person> {
  private final int age;

  public Person(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  @Override
  public int compareTo(Person o) {
    return this.age - o.age;
  }

  @Override
  public String toString() {
    return "Person{" + "age=" + age + '}';
  }
}
