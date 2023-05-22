package JavaAdvance.Exercises_Generics.Generic_Count_Method_Doubles_06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box<>();

        for (int i = 0; i < times; i++) {
            box.add(Double.parseDouble(scanner.nextLine()));
        }

        System.out.println(box.count(Double.parseDouble(scanner.nextLine())));
    }
}
