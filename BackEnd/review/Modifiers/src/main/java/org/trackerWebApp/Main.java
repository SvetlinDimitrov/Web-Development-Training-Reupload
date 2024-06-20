package org.trackerWebApp;

import package2.PublicClass;

public class Main {
  public static void main(String[] args) {
    /*
     * In Java, there are four access modifiers:

     * Private: The access level of a private modifier is only within the class.
     * It cannot be accessed from outside the class.

     * Default (No modifier): If you do not specify any access level, it will be the default.
     * The access level of a default modifier is only within the package.
     * It cannot be accessed from outside the package.
     * If you do not specify any modifier, it is treated as default by default.

     * Protected: The access level of a protected modifier is within the package and outside the package through child class.
     * If you do not make the child class, it cannot be accessed from outside the package.

     * The access level of a public modifier is everywhere.
     * It can be accessed from within the class, outside the class, within the package and outside the package.

     */

    // Create an object of class with public access modifier from another package
    PublicClass myObj = new PublicClass();

    // Create an object of class with default access modifier from another package
    // It will give an error because the class can be reached only from the same package
    // DefaultClass myObj3 = new DefaultClass();
    // Create an object of class with default access modifier from current package
    DefaultClassMain myObj4 = new DefaultClassMain();

    // Create an object of class with protected access modifier from another package
    // It will give error because in Java the protected access modifier is not allowed at the class level

    // Crate an object of class with private access modifier from another package
    // It will give an error because in Java the private access modifier is not allowed at the class level

    // System.out.println(myObj4.x);
    // It wll give an error because the variable is private
    // System.out.println(myObj4.y);

    // This will work in this class because there are in the same package , but it will give an error in another package
    // System.out.println(myObj4.z);
    // System.out.println(myObj4.w);
//    DefaultClassMain.a = 30;
//    System.out.println(DefaultClassMain.a);

//    System.out.println(myObj4.b);
    //this will give and error because the variable is final
//    myObj4.b = 40;

//    DefaultClassMain.myStaticMethod();

    Test test = new Test() {

    };

    // Create the anonymous class and store it in a variable of the anonymous class type
    MyAbstractClass myAbstractClass = new MyAbstractClass() {
      private final int CONSTANT = 150;

      //if this method is not impl in MyAbstractClass it can`t be accessed
      public int getConstant() {
        return CONSTANT;
      }
    };

    // Access the method through a reference of the anonymous class type
    // int constantValue = myAbstractClass.getConstant();
  }
}