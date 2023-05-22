package ProgramingFundamentalsJava.More_Exercises_Regular_Expressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            input = ConvertWord(input, key);
            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^\\@\\-\\!\\:\\>]+!(?<behavior>[G|B])!");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s%n", matcher.group("name"));
            }
            input = scanner.nextLine();
        }
    }


    private static String ConvertWord(String input, int key) {
        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int currentChar = input.charAt(i) - key;
            char future = (char) currentChar;
            newWord.append(future);
        }
        return newWord.toString();
    }
}
