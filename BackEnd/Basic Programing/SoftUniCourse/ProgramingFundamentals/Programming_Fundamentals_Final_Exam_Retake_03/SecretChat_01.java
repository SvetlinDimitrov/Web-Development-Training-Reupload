package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_Retake_03;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while(!input.equals("Reveal")){
            String [] commands = input.split(":\\|:");
            if(commands[0].equals("InsertSpace")){
                int index = Integer.parseInt(commands[1]);
                word.insert(index , " ");
                System.out.printf("%s%n",word.toString());
            }else if (commands[0].equals("Reverse")){
                if(word.toString().contains(commands[1])){
                    String newWord = word.toString().replace(commands[1] , "");
                    word.delete(0,word.length());
                    word.append(newWord);
                    word.append(Reverse(commands[1]));
                    System.out.printf("%s%n",word.toString());
                }else{
                    System.out.println("error");
                }
            }else if (commands[0].equals("ChangeAll")){
                if(word.toString().contains(commands[1])){
                    String newWord = word.toString().replace(commands[1] , commands[2]);
                    word.delete(0,word.length());
                    word.append(newWord);
                    System.out.printf("%s%n",word.toString());
                }
            }
            input= scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n",word.toString());
    }

    private static String Reverse(String command) {
        StringBuilder newWord = new StringBuilder();
        for (int i = command.length()-1; i >= 0; i--) {
            newWord.append(command.charAt(i));
        }
        return  newWord.toString();
    }
}
