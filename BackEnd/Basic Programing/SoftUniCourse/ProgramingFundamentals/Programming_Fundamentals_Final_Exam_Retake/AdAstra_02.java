package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_Retake;



import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(#|\\|)(?<itemName>[A-Za-z ]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> food = new ArrayList<>();
        List<String> date = new ArrayList<>();
        List<Integer> calories = new ArrayList<>();
        int sumCalories = 0;

        while(matcher.find()){
            food.add(matcher.group("itemName"));
            date.add(matcher.group("date"));
            calories.add(Integer.parseInt(matcher.group("calories")));
        }
        for (int i = 0; i < calories.size(); i++) {
            sumCalories+=calories.get(i);
        }

        System.out.printf("You have food to last you for: %d days!%n",sumCalories/2000);
        for (int i = 0; i < food.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n",food.get(i) , date.get(i) , calories.get(i));
        }
    }
}
