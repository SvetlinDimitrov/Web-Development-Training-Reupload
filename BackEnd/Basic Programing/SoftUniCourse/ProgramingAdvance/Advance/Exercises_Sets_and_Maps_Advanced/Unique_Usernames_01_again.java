package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Unique_Usernames_01_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set = new LinkedHashSet<>();
        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            set.add(scanner.nextLine());
        }
        set.forEach(e-> System.out.println(e));
    }
}
