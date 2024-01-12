package JavaAdvance.Exercises_Generics.Generic_Count_Method_Strings_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < times; i++) {
            box.add(scanner.nextLine());
        }

        System.out.println(box.count(scanner.nextLine()));
    }
}
