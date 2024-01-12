package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_07_August_2022;

import java.util.Locale;
import java.util.Scanner;

public class Hogwarts_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Abracadabra")) {
            String[] commands = input.split(" ");
            if (commands[0].equals("Abjuration")) {
                word = word.toUpperCase(Locale.ROOT);
                System.out.println(word);
            } else if (commands[0].equals("Necromancy")) {
                word = word.toLowerCase(Locale.ROOT);
                System.out.println(word);
            } else if (commands[0].equals("Illusion")) {
                int index = Integer.parseInt(commands[1]);
                String letter = commands[2];
                if (index >= 0 && index < word.length()) {
                    word = Illusion(word, index, letter);
                    System.out.println("Done!");
                }else{
                    System.out.println("The spell was too weak.");
                }
            }else if ( commands[0].equals("Divination")) {
                String sub1 = commands[1];
                String sub2 = commands[2];
                if (word.contains(sub1)) {
                    word = word.replace(sub1, sub2);
                    System.out.println(word);
                }
            }else if (commands[0].equals("Alteration") ){
                String sub = commands[1];
                if(word.contains(sub)){
                    word = word.replace(sub , "");
                    System.out.println(word);
                }
            }else {
                System.out.println("The spell did not work!");
            }
            input = scanner.nextLine();
        }
    }

    private static String Illusion(String word, int index, String letter) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (index == i) {
                newWord.append(letter);
            } else {
                newWord.append(word.charAt(i));
            }
        }
        return newWord.toString();
    }
}
