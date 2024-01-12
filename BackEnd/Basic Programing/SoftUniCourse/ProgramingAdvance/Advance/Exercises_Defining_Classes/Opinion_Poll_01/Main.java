package JavaAdvance.Exercises_Defining_Classes.Opinion_Poll_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        List<Person> peoples = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            String [] input = scanner.nextLine().split(" ");
            peoples.add(new Person(input[0] , Integer.parseInt(input[1])));

        }
        peoples.stream().filter(e-> e.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach((e) -> System.out.printf("%s - %d%n",e.getName() , e.getAge()));
    }
}
