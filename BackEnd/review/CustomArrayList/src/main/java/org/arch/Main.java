package org.arch;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    MyArrayList<Integer> myList = new MyArrayList<>();
    myList.add(1);
    myList.add(2);
    myList.add(3);
    myList.add(4);
    myList.remove(Integer.valueOf(2));
//    System.out.println(myList.contains(2));
//    System.out.println(myList.contains(3));
//    System.out.println(myList.containsAll(Arrays.asList(1,3, 3)));
    System.out.println(myList.subList(0, 2));
  }
}