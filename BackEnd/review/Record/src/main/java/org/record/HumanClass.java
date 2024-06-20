package org.record;

public class HumanClass implements Animal {

  private final String name;
  private final int age;
  public static String Constant;


  public static void setConstant(String constant) {
    Constant = constant;
  }

  public HumanClass(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public void eat() {
    System.out.println("Human " + name + " at age " + age + " is eating.");
  }

  @Override
  public void sleep() {
    System.out.println("Human " + name + " at age " + age + " is sleeping.");
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }
}
