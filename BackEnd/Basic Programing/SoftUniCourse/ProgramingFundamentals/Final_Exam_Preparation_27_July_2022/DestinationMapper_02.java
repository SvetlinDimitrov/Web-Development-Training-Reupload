package ProgramingFundamentalsJava.Final_Exam_Preparation_27_July_2022;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(@|#)(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);
        int validParts = 0;

        Map<String ,String> map = new LinkedHashMap<>();

        while(matcher.find()){
            String wordOne = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            validParts++;
            if(AreThereTheSame(wordOne ,secondWord)){
                map.put(wordOne ,secondWord);
            }
        }
        int count = 1;
        StringBuilder finalPrint = new StringBuilder();
        if(validParts == 0){
            System.out.println("No word pairs found!");
        }else {
            System.out.printf("%d word pairs found!%n", validParts);
        }
        if(map.isEmpty()){
            System.out.println("No mirror words!");
        }else{
            System.out.println("The mirror words are:");
            for (Map.Entry<String,String> entry : map.entrySet()) {
                if (count == map.size()) {
                    finalPrint.append(String.format("%s <=> %s", entry.getKey(), entry.getValue()));
                } else {
                    finalPrint.append(String.format("%s <=> %s, ", entry.getKey(), entry.getValue()));
                    count++;
                }
            }
        }
        String finalBra = finalPrint.toString();

        System.out.println(finalBra);
    }

    private static boolean AreThereTheSame(String wordOne, String secondWord) {
        boolean yea = false;
        if(wordOne.length() == secondWord.length()){
            for (int i = 0; i < wordOne.length(); i++) {
                char wordOneChar = wordOne.charAt(i);
                char wordTwoChar = secondWord.charAt(secondWord.length()-1-i);
                if(wordOneChar == wordTwoChar){
                    yea = true;
                }else{
                    return false;
                }
            }
        }
        return yea;
    }
}
