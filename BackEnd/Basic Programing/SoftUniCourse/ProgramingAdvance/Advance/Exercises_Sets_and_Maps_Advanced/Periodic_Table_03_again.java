package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Periodic_Table_03_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int times = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < times; i++) {
            String [] input = scanner.nextLine().split(" ");
            Arrays.stream(input).forEach(set::add);
        }
        set.forEach(e-> System.out.printf("%s ",e));
    }
}
