package ProgramingFundamentalsJava.More_Exercises_Regular_Expressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] array = scanner.nextLine().split(", ");
        Pattern pattern = Pattern.compile("[A-Za-z]*((?:@|#|\\$|\\^){6,10})[A-Za-z]*\\1[A-Za-z]*");

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].replaceAll("\\s+","");
            Matcher matcher = pattern.matcher(array[i]);
            if(array[i].length() == 20){
                if(matcher.find()) {
                    if (matcher.group(1).length() == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", array[i], matcher.group(1).length(), matcher.group(1).charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%s%n", array[i], matcher.group(1).length(), matcher.group(1).charAt(0));
                    }
                }else{
                    System.out.printf("ticket \"%s\" - no match%n",array[i]);
                }
            }else{
                System.out.println("invalid ticket");
            }
        }
    }
}
