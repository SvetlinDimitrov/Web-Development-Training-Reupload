package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_05;

import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while(!input.equals("Generate")){
            String [] commands = input.split(">>>");
            if(commands[0].equals("Contains")){
                if(word.toString().contains(commands[1])){
                    System.out.println(word.toString());
                }else{
                    System.out.println("Substring not found!");
                }
            }else if (commands[0].equals("Flip")){
                int startIndex = Integer.parseInt(commands[2]);
                int endIndex = Integer.parseInt(commands[3]);
                if(commands[1].equals("Upper")){
                    String wordToReplace = word.substring(startIndex , endIndex).toUpperCase(Locale.ROOT);
                    String newWord = word.toString().replace(word.substring(startIndex , endIndex) , wordToReplace);
                    word.delete(0 , word.toString().length());
                    word.append(newWord);
                    System.out.println(word.toString());
                }else if (commands[1].equals("Lower")){
                    String wordToReplace = word.substring(startIndex , endIndex).toLowerCase(Locale.ROOT);
                    String newWord = word.toString().replace(word.substring(startIndex , endIndex) , wordToReplace);
                    word.delete(0 , word.toString().length());
                    word.append(newWord);
                    System.out.println(word.toString());
                }
            }else if (commands[0].equals("Slice") ){
                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);
                word.delete(startIndex , endIndex);
                System.out.println(word.toString());
            }
            input= scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s",word.toString());
    }
}
