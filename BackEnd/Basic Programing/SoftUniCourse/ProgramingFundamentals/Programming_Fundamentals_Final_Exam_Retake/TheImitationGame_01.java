package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_Retake;

import java.util.Scanner;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while(!input.equals("Decode")){
            String command = input.split("\\|")[0];
            switch (command){
                case "Move":
                    int moveLetter = Integer.parseInt(input.split("\\|")[1]);
                    String newWord = MoveStringLetter(word , moveLetter);
                    word.delete(0 , word.length()+1);
                    word.append(newWord);
                    break;
                case "Insert":
                    int index = Integer.parseInt(input.split("\\|")[1]);
                    String value = input.split("\\|")[2];
                    if(index>=0 && index <= word.toString().length()){
                        word.insert(index , value);
                    }
                    break;
                case "ChangeAll":
                    String substring = input.split("\\|")[1];
                    String replacement = input.split("\\|")[2];
                    if(word.toString().contains(substring)){
                        String Word = word.toString().replace(substring,replacement);
                        word.delete(0 , word.length()+1);
                        word.append(Word);
                    }
            }
            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s",word.toString());
    }

    private static String MoveStringLetter(StringBuilder word, int moveLetter) {
        for (int i = 0; i < moveLetter; i++) {
            char saveLetter = word.charAt(0);
            word.deleteCharAt(0);
            word.append(saveLetter);
        }
        return word.toString();
    }
}
