package JavaAdvance.Exercises_Iterators_and_Comparators.Strategy_Pattern_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        List<Person> list = new ArrayList<>();


        for (int i = 0; i < times; i++) {
            String input = scanner.nextLine();
            list.add(new Person(input.split(" ")[0] , Integer.parseInt(input.split(" ")[1])));
        }

        list.stream().sorted(new Person.CompareByName()).forEach(e-> System.out.printf("%s %d%n", e.getName(),e.getAge()));
        list.stream().sorted(new Person.CompareByAge()).forEach(e-> System.out.printf("%s %d%n", e.getName(),e.getAge()));

    }
}
