package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        School school = new School();
        fillSchool(school);
        System.out.println(school.iterator().next());
        System.out.println(school.iterator().next());
        System.out.println(school.iterator().next());
        System.out.println(school.iterator().next());
        System.out.println(school.iterator().next());
        System.out.println(school.iterator().next());
        System.out.println(school.iterator().next());

    }
    public static void fillSchool(School school){
        school.addListOfStudents(List.of(
                new Student("a1" , 1),
                new Student("a2" , 1),
                new Student("a3" , 1),
                new Student("a4" , 1),
                new Student("a5" , 1),
                new Student("a6" , 1))
        );
    }
}