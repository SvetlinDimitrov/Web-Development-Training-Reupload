package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Periodic_Table_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < times; i++) {
            String [] input = scanner.nextLine().split(" ");
            set.addAll(Arrays.asList(input));
        }
        set.forEach(e -> System.out.printf("%s ",e));
    }
}
