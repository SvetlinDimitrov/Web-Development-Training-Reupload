package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUni_Party_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> normalGuests = new TreeSet<>();
        Set<String> vipGuests = new LinkedHashSet<>();
        while(!input.equals("PARTY")){
            if(Character.isDigit(input.charAt(0))){
                vipGuests.add(input);
            }else{
                normalGuests.add(input);
            }
            input = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();
        while(!secondInput.equals("END")){
            normalGuests.remove(secondInput);
            vipGuests.remove(secondInput);

            secondInput = scanner.nextLine();
        }
        int sum = normalGuests.size() + vipGuests.size();
        System.out.println(sum);
        System.out.println(String.join(System.lineSeparator(), vipGuests));
        System.out.println(String.join(System.lineSeparator(), normalGuests));
    }
}
