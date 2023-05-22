package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Parking_Lot_01_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> park = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String command = input.split(", ")[0];
            String car = input.split(", ")[1];
            switch (command) {
                case "IN":
                    park.add(car);
                    break;
                case "OUT":
                    park.remove(car);
                    break;
            }
            input = scanner.nextLine();
        }
        if (park.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            park.forEach(e -> System.out.println(e));
        }
    }
}
