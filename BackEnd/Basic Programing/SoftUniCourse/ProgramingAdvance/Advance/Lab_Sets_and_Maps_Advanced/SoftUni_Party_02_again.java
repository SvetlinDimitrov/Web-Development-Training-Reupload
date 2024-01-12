package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUni_Party_02_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> people = new TreeSet<>();
        String input = scanner.nextLine();
        while(!input.equals("PARTY")){
            people.add(input);
            input= scanner.nextLine();
        }
        input = scanner.nextLine();
        while(!input.equals("END")){
            people.remove(input);
            input= scanner.nextLine();
        }
        System.out.println(people.size());
        people.forEach(e->System.out.println(e));
    }
}
