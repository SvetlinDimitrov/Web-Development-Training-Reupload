package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_05;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(::|\\*\\*)(?<word>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> emoji = new ArrayList<>();
        int count = 0;
        double valueSum = 1;

        while(matcher.find()){
            count++;
            emoji.add(matcher.group());
        }
        Pattern pattern1 = Pattern.compile("[0-9]");
        Matcher matcher1 = pattern1.matcher(input);
        while (matcher1.find()){
            valueSum*=Integer.parseInt(matcher1.group());
        }

        System.out.printf("Cool threshold: %.0f%n",valueSum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n",count);
        for (int i = 0; i < emoji.size(); i++) {
            String newEmoji ="";
            if(emoji.get(i).contains(":")) {
                newEmoji = emoji.get(i).replace(":", "");
            }else {
                newEmoji = emoji.get(i).replace("*", "");
            }
            if(Value(newEmoji) > valueSum){
                System.out.printf("%s%n",emoji.get(i));
            }
        }

    }

    private static int Value(String word) {
        int sum=0;
        for (int i = 0; i < word.length(); i++) {
            int currentNum = word.charAt(i);
            sum+=currentNum;
        }
        return sum;
    }
}
