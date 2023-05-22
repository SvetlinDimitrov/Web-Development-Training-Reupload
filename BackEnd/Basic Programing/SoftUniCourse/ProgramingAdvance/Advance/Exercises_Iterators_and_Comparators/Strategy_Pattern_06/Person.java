package JavaAdvance.Exercises_Iterators_and_Comparators.Strategy_Pattern_06;

import java.util.Comparator;
import java.util.Iterator;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static class CompareByName implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            if (o1.getName().length() == o2.getName().length()) {
                return Character.compare(o1.getName().charAt(0), o2.getName().charAt(0));
            }
            return Integer.compare(o1.getName().length(), o2.getName().length());
        }
    }
    public static class CompareByAge implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.getAge() , o2.getAge());
        }
    }

}




