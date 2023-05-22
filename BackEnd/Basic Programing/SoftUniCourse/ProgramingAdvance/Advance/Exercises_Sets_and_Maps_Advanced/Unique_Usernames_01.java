package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Unique_Usernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times =  Integer.parseInt(scanner.nextLine());
        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < times; i++) {
            set.add(scanner.nextLine());
        }
        set.forEach(System.out::println);
    }
}
