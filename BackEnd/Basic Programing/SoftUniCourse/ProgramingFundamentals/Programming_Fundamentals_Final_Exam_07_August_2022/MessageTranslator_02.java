package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_07_August_2022;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<string>[A-Za-z]{8,})\\]");

        for (int i = 0; i < times; i++) {
            Matcher matcher = pattern.matcher(scanner.nextLine());
            if(matcher.find()){
                String command = matcher.group("command");
                String word = matcher.group("string");
                System.out.printf("%s: ",command);

                for (int j = 0; j <word.length() ; j++) {
                    int currentNum = word.charAt(j);
                    System.out.printf("%d ",currentNum);
                }
                System.out.println();
            }else{
                System.out.println("The message is invalid");
            }
        }
    }
}
