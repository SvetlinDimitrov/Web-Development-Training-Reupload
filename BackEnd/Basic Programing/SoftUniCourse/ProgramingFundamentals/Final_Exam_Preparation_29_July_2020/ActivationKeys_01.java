package ProgramingFundamentalsJava.Final_Exam_Preparation_29_July_2020;

import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word= new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while(!input.equals("Generate")){
            String command = input.split(">>>")[0];
            if(command.equals("Contains")) {
                //"Contains>>>{substring}":
                String wordToContain = input.split(">>>")[1];
                if(word.toString().contains(wordToContain)){
                    System.out.printf("%s contains %s.%n",word,wordToContain);
                }else {
                    System.out.println("Substring not found!");
                }
            }else if (command.equals("Flip")){
                //"Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}":
                String command2 = input.split(">>>")[1];
                int indexStart = Integer.parseInt(input.split(">>>")[2]);
                int indexEnd = Integer.parseInt(input.split(">>>")[3]);
                if(ValidIndex(word,indexStart) && ValidIndex(word,indexEnd)){
                    String newWord = GenerateMyWord(word, indexStart, indexEnd, command2);
                    word.delete(0, word.length());
                    word.append(newWord);
                    System.out.println(newWord);
                }
            }else if (command.equals("Slice")) {
                // "Slice>>>{startIndex}>>>{endIndex}":
                int indexStart = Integer.parseInt(input.split(">>>")[1]);
                int indexEnd = Integer.parseInt(input.split(">>>")[2]);
                if (ValidIndex(word, indexStart) && ValidIndex(word, indexEnd)) {
                    word.delete(indexStart, indexEnd);
                    System.out.printf("%s%n", word.toString());
                }
            }


            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s",word.toString());
    }

    private static boolean ValidIndex(StringBuilder word, int indexStart) {
        return (indexStart>=0 && indexStart<=word.length()-1);
    }

    private static String GenerateMyWord(StringBuilder word, int indexStart, int indexEnd , String command2) {
        String copyWord = word.substring(indexStart , indexEnd);
        String newWord = "";
        if ( command2 .equals("Upper")){
            newWord = copyWord.toUpperCase(Locale.ROOT);
        }else{
            newWord = copyWord.toLowerCase(Locale.ROOT);
        }
        return word.toString().replace(copyWord , newWord);
    }
}
