package org.record;

/*
 * In Java, a record is a final class and it implicitly extends the java.lang.Record class.
 * Due to Java's single inheritance model, a class can only extend one superclass.
 * Since a record already extends java.lang.Record, it cannot extend any other class.
 *
 * This design decision is part of the philosophy behind records, which are intended to be simple data carriers.
 * Allowing records to extend other classes could lead to complex inheritance hierarchies and mutable state,
 * which goes against the simplicity and immutability that records are designed to enforce.
 */
public record HumanRecord(String name, int age) implements Animal {

  /*
   * In Java, records are a special kind of class that are intended to be simple data carriers.
   * They have some restrictions compared to regular classes.
   * One of these restrictions is that all instance fields in a record are implicitly final and are derived from the record's
   * state description (the parameters declared in the record header).
   * */
//  public String name2 = "John";
  /*
   * On the other hand, public static String Constant; is a static field, not an instance field.
   * Static fields are not part of any particular instance of a class or record, so they are not subject to the same restrictions.
   * This is why public static String Constant; is allowed in a record.
   */
  public static String Constant;

  //Constructor
  /*
  The constructor you've written for the HumanRecord record is not working because in Java,
   records have a canonical constructor that is automatically provided by the compiler.
   This constructor takes all the fields declared in the record header as parameters.
   In your case, the canonical constructor is HumanRecord(String name, int age).

  public HumanRecord(String name){
    this.name = name;
    this.age = 0;
  }
   */

  /*
   * If you want to provide additional constructors, they must call the canonical constructor.
   * In your case, you're trying to provide a constructor that only takes a String name and sets age to 0.
   * You can do this by calling the canonical constructor with this(name, 0). Here's how you can modify your constructor:
   */
  public HumanRecord(String name) {
    this(name, 0);
  }

  public HumanRecord(int age) {
    this("John");
  }

  //this is the conical constructor
  public HumanRecord {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or blank");
    }
    if (age < 0) {
      throw new IllegalArgumentException("Age must be non-negative");
    }
  }

  //THis is working fine
  public static void setConstant(String constant) {
    Constant = constant;
  }

  //Also this is working fine
  @Override
  public void eat() {
    System.out.println("Human " + name + " at age " + age + " is eating.");
  }

  @Override
  public void sleep() {
    System.out.println("Human " + name + " at age " + age + " is sleeping.");
  }

  //Records are implicitly final and immutable. Once a record is created, its state cannot be changed.
  public void setName(String name) {
//     this.name = name; // Compilation error
  }
}
