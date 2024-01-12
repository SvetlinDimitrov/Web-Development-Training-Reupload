package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_04;

import java.util.Scanner;

public class PasswordReset_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word =new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while(!input.equals("Done")){
            String command = input.split(" ")[0];
            switch (command){
                case "TakeOdd":
                    String newWord = SecretWord(word);
                    System.out.println(newWord);
                    word.delete(0,word.toString().length()+1);
                    word.append(newWord);
                    break;
                case "Cut":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    int length = Integer.parseInt(input.split(" ")[2]);
                    word.delete(index , index+length);
                    System.out.println(word.toString());
                    break;
                case "Substitute":
                    String substring = input.split(" ")[1];
                    String substitute = input.split(" ")[2];
                    if(word.toString().contains(substring)) {
                        String subWord = word.toString().replace(substring, substitute);
                        System.out.println(subWord);
                        word.delete(0,word.toString().length()+1);
                        word.append(subWord);
                    }else{
                        System.out.println("Nothing to replace!");
                    }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s",word.toString());
    }

    private static String SecretWord(StringBuilder word) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 1; i < word.toString().length(); i++) {
            if(i%2!=0){
                newWord.append(word.toString().charAt(i));
            }
        }
        return newWord.toString();
    }
}
