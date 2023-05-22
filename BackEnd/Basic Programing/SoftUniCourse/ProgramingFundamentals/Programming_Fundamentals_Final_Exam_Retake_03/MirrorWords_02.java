package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_Retake_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(@|#)(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTow>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        List<String> mirrorWords = new ArrayList<>();

        while(matcher.find()){
            count++;
            if(ReverseWord(matcher.group("wordOne")).equals(matcher.group("wordTow"))){
                mirrorWords.add(matcher.group("wordOne"));
            }
        }
        if(count == 0 ){
            System.out.println("No word pairs found!");
        }else{
            System.out.printf("%d word pairs found!%n",count);
        }
        if(mirrorWords.isEmpty()){
            System.out.println("No mirror words!");
        }else{
            System.out.println("The mirror words are:");
            StringBuilder print = new StringBuilder();
            print.append(String.format("%s <=> %s",mirrorWords.get(0) , ReverseWord(mirrorWords.get(0))));
            for (int i = 1; i < mirrorWords.size(); i++) {
                print.append(String.format(", %s <=> %s",mirrorWords.get(i) , ReverseWord(mirrorWords.get(i))));
            }
            System.out.printf("%s",print.toString());
        }
    }

    private static String ReverseWord(String wordOne) {
        StringBuilder newWord = new StringBuilder();
        for (int i = wordOne.length()-1; i >=0 ; i--) {
            newWord.append(wordOne.charAt(i));
        }
        return newWord.toString();
    }
}
