package org.record;

public class Main {
  public static void main(String[] args) {

    /*
    Classes vs Records

    Purpose: Records are intended to be simple data carriers, primarily used for immutable data.
    Classes, on the other hand, can be used for a wide range of purposes, including mutable data, complex business logic, and more.

    Immutability: Records are implicitly final and immutable. Once a record is created, its state cannot be changed.
    Classes can be mutable or immutable, depending on how they are designed.

    Fields: In a record, all fields are final. In a class, fields can be either mutable or immutable.

    Inheritance: Records cannot extend other classes or records, and cannot be extended.
    Classes can extend other classes and can be extended.

    Methods: Records automatically provide several standard methods like equals(), hashCode(), and toString(),
    based on the record's state. In a class, these methods must be manually overridden if custom behavior is needed.

    Compactness: Records can be more compact because they don't require explicit getters, setters,
    or other boilerplate code. Classes require explicit declaration of fields, constructors, and methods.

    Components: Records have a notion of components, the state descriptions,
    which are used to declare the state and automatically implement accessors, equals(), hashCode(), and toString().
    Classes do not have this feature.

    Serialization: Records provide a canonical constructor that matches the declared state description,
    which can be used for serialization frameworks. Classes require custom serialization methods
    if the default is not suitable.
    */

//    Animal human = new HumanRecord("asd" , 123);
//    human = new HumanRecord("sadasd" , 123);
//    System.out.println(human);
    HumanRecord human2 = new HumanRecord("sd" , 123123);
    human2.setConstant("asdadasd");
    System.out.println(HumanRecord.Constant);
    HumanClass humanClass = new HumanClass("aSDASD" , 12313);
    humanClass.setConstant("asdasdasd");
    System.out.println(HumanClass.Constant);
  }
}