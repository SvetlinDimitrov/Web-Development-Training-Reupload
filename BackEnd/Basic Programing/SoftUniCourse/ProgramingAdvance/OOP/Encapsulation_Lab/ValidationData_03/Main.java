package JavaOOP.Encapsulation_Lab.ValidationData_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
                String input = scanner.nextLine();
                String firstName= input.split("\\s+")[0];
                String lastName= input.split("\\s+")[1];
                int age = Integer.parseInt(input.split("\\s+")[2]);
                double salary = Double.parseDouble(input.split("\\s+")[3]);
                try{
                    personList.add(new Person(firstName,lastName,age,salary));
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
        }
        double percentSalary = Double.parseDouble(scanner.nextLine());
        for (Person person : personList) {
            person.increaseSalary(percentSalary);
            System.out.println(person);
        }
    }
}
