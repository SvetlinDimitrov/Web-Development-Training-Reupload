package ProgramingFundamentalsJava.More_Exercises_Regular_Expressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");
        String secretWord = "";
        Map<Character , Integer> map = new TreeMap<>();
        List<String> words = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            String word = input[i];
            switch (i) {
                case 0:
                    Pattern pattern1 = Pattern.compile("([\\#\\$\\%\\*\\&]{1})(?<secretWord>[A-Z]+)\\1");
                    Matcher matcher = pattern1.matcher(word);
                    if(matcher.find()) {
                        secretWord = matcher.group("secretWord");
                    }
                    break;
                case 1:
                    Pattern pattern2 = Pattern.compile("\\d{2}:\\d{2}");
                    Matcher matcher2 = pattern2.matcher(word);
                    while(matcher2.find()){
                        words.add(matcher2.group());
                    }

                    for (int j = 0; j < secretWord.length(); j++) {
                        int currentNum = secretWord.charAt(j);
                        for (int k = 0; k < words.size(); k++) {
                            if(words.get(k).contains(currentNum + "")){
                                map.put(secretWord.charAt(j) , Integer.parseInt(words.get(k).split(":")[1]));
                            }
                        }

                    }
                    break;

                case 2:
                    words.clear();
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        String search = String.format("\\b%s[\\S]{%d}\\b", entry.getKey(), entry.getValue());
                        Pattern pattern3 = Pattern.compile(search);
                        Matcher matcher3 = pattern3.matcher(word);
                        if (matcher3.find()) {
                            words.add(matcher3.group());
                        }
                    }
                    break;
            }
        }
        for (int i = 0; i < secretWord.length(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if(secretWord.charAt(i) == words.get(j).charAt(0)){
                    System.out.printf("%s%n",words.get(j));
                    break;
                }
            }
        }
    }
}
