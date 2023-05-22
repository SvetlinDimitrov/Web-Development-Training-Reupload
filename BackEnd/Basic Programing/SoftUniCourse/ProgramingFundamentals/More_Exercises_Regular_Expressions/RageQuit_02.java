package ProgramingFundamentalsJava.More_Exercises_Regular_Expressions;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase(Locale.ROOT);
        Pattern pattern = Pattern.compile("\\D+\\d+");
        Matcher matcher = pattern.matcher(input);
        StringBuilder word = new StringBuilder();

        while(matcher.find()){
            String currentWord = matcher.group();
            int currentNum = GiveMeNumber(currentWord);
            for (int i = 0; i < currentNum; i++) {
                word.append(ConvertNow(currentWord));
            }
        }
        List<Character> checker = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if(!checker.contains(word.charAt(i))){
                checker.add(word.charAt(i));
            }
        }
        System.out.printf("Unique symbols used: %d%n",checker.size());
        System.out.printf("%s",word.toString());

    }

    private static int GiveMeNumber(String currentWord) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < currentWord.length(); i++) {
            if(Character.isDigit(currentWord.charAt(i))){
                newWord.append(currentWord.charAt(i));
            }
        }
        return Integer.parseInt(newWord.toString());
    }

    public  static String ConvertNow (String word ){
        StringBuilder words = new StringBuilder();
        for (int i = 0; i <word.length() ; i++) {
            if(!Character.isDigit(word.charAt(i))){
                words.append(word.charAt(i));
            }

        }
        return words.toString();
    }
}
