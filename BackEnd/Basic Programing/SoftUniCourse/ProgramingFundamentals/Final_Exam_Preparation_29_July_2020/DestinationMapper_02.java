package ProgramingFundamentalsJava.Final_Exam_Preparation_29_July_2020;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        Pattern pattern = Pattern.compile("(=|\\/)(?<name>[A-Z]{1}[A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(word);
        int sum = 0;
        List<String> destination = new ArrayList<>();

        while(matcher.find()){
            sum+=matcher.group("name").length();
            destination.add(matcher.group("name"));
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ",destination));
        System.out.printf("Travel Points: %d",sum);
    }
}
