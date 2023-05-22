package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Parking_Lot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> park = new LinkedHashSet<>();
        String[] input = scanner.nextLine().split(", ");
        while (!input[0].equals("END")) {
            switch (input[0]) {
                case "IN":
                    park.add(input[1]);
                    break;
                case "OUT":
                    park.remove(input[1]);
                    break;
            }
            input = scanner.nextLine().split(", ");
        }
        if(park.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String s : park) {
                System.out.println(s);
            }
        }
    }
}
