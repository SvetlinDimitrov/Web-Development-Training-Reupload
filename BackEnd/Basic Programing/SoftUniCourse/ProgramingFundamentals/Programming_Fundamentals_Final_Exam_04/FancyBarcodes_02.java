package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_04;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            Pattern pattern = Pattern.compile("@#{1,}(?<word>[A-Z]{1}[A-Za-z0-9]+[A-Z]{1})@#{1,}");
            Matcher matcher = pattern.matcher(scanner.nextLine());
                if (matcher.find() && matcher.group("word").length() >= 6) {
                    System.out.printf("Product group: %s%n", DigitBra(matcher.group("word")));
                } else {
                    System.out.println("Invalid barcode");
                }
            }
    }

    private static String DigitBra(String word) {
        StringBuilder number = new StringBuilder();

        for (int i = 0; i <word.length() ; i++) {
            if(Character.isDigit(word.charAt(i))){
                number.append(word.charAt(i));
            }
        }
        if(number.toString().isEmpty()){
            return "00";
        }else{
            return number.toString();
        }
    }
}
