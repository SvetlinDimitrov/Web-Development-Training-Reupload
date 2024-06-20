package org.annotations;

@ClassLeveL
public class Person {

  @ValidateName(minLength = 3, maxLength = 10)
  private final String name;

  public Person(String name) {
    this.name = name;
  }

  @RunMethodImitatively(times = 4)
  public void eat() {
    System.out.println("Person is eating");
  }

  @RunMethodImitatively(times = 2)
  public void sleep() {
    System.out.println("Person is sleeping");
  }

  public void walk() {
    System.out.println("Person is walking");
  }
}
