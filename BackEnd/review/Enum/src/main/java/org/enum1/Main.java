package org.enum1;

public class Main {
  public static void main(String[] args) {
    /*
    Enums, short for enumerations, are a special type of class in Java that represents a group of constants
    (unchangeable variables, like final variables).

    Here are some key points about enums:
    Defined Constants: Enums define a class type by enumerating its values.
    For example, you could represent the days of the week as an enum.

    Type Safety: Enums provide type safety because they ensure that a variable can only be assigned one
    of the predefined constants.

    Singleton: Each enum value is an instance of the enum class and these instances are globally accessible.
    This makes enums a good choice for singleton implementation.

    Switch Statement: Enums can be used in switch statements, making your code more readable.

    Methods and Fields: Enums can have methods, fields, and constructors. They can also implement interfaces.

    Built-in Methods: Enums have built-in methods such as values() which returns an array of all enum constants in the
    order they are declared, and valueOf(String name) which returns the enum constant of the specified enum type with
    the specified name.
    */

    AllAnimals bear = AllAnimals.BEAR;
    bear.lifeStyle();

    System.out.println("enums come from: " + AllAnimals.class.getSuperclass());
    System.out.println(AllAnimals.class.getSuperclass() + " come from : " + AllAnimals.class.getSuperclass().getSuperclass());
  }

}