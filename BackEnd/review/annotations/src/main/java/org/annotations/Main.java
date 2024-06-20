package org.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
    /*
    Annotations in Java are a form of metadata that can be added to the code and can be read by the JVM or other
    tools at runtime to perform certain actions. They are introduced with the '@' symbol.

    Creating a custom annotation involves the following steps:

    Declare the annotation using the @interface keyword.
    Define the elements (variables) of the annotation.
    Apply the annotation to the code.
    Read the annotation using reflection.
    */

    Person person = new Person("John Doe");

    checkAnnotation(person);

    System.out.println();

    methodAnnotations(person);

    System.out.println();

    validateName(person);
  }

  private static void validateName(Person person) throws IllegalAccessException {
    for (Field filed : person.getClass().getDeclaredFields()) {
      filed.setAccessible(true);
      if (filed.isAnnotationPresent(ValidateName.class)) {
        Object o = filed.get(person);
        if (o instanceof String name) {
          int minLength = filed.getAnnotation(ValidateName.class).minLength();
          int maxLength = filed.getAnnotation(ValidateName.class).maxLength();
          if (name.length() >= minLength && name.length() <= maxLength) {
            System.out.println("Name is valid");
          } else {
            System.out.println("Name is not valid");
          }
        }
      }
    }
  }

  private static void methodAnnotations(Person person) throws IllegalAccessException, InvocationTargetException {
    Class<? extends Person> aClass = person.getClass();
    for (Method method : aClass.getMethods()) {
      if (method.isAnnotationPresent(RunMethodImitatively.class)) {
        int times = method.getAnnotation(RunMethodImitatively.class).times();
        for (int i = 0; i < times; i++) {
          method.invoke(person);
        }
      }
    }
  }

  private static void checkAnnotation(Person person) {
    if (person.getClass().isAnnotationPresent(ClassLeveL.class)) {
      System.out.println("Person class is annotated with ClassLeveL annotation");
    } else {
      System.out.println("Person class is not annotated with ClassLeveL annotation");
    }
  }
}