package JavaAdvance.Exams.Java_Advanced_Exam19February2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Food_Finder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [] firstWord = {'p','e','a','r'};
        char [] secondWord = {'f','l','o','u','r'};
        char [] thirdWord = {'p','o','r','k'};
        char [] oliveWord = {'o','l','i','v','e'};

        ArrayDeque<Character> vowels = new ArrayDeque<>();
        ArrayDeque<Character> consonants = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e-> vowels.offer(e.charAt(0)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e-> consonants.push(e.charAt(0)));

        while(!vowels.isEmpty() && !consonants.isEmpty()){
            char vowel = vowels.poll();
            char consonant = consonants.pop();
            ChangingArrays(vowel , consonant , firstWord);
            ChangingArrays(vowel , consonant , secondWord);
            ChangingArrays(vowel , consonant , thirdWord);
            ChangingArrays(vowel , consonant , oliveWord);
            vowels.offerLast(vowel);

        }
        StringBuilder print = new StringBuilder();
        int wordsCount = 0;
        if(CheckIfItsEmpty(firstWord) == 1) {
            wordsCount++;
            print.append(String.format("%s%n","pear"));
        }

        if(CheckIfItsEmpty(secondWord) == 1) {
            wordsCount++;
            print.append(String.format("%s%n","flour"));
        }

        if(CheckIfItsEmpty(thirdWord) == 1) {
            wordsCount++;
            print.append(String.format("%s%n","pork"));
        }

        if(CheckIfItsEmpty(oliveWord) == 1) {
            wordsCount++;
            print.append(String.format("%s%n","olive"));
        }

        System.out.printf("Words found: %d%n",wordsCount);
        System.out.println(print.toString());
    }

    private static int CheckIfItsEmpty(char[] firstWord) {
        boolean isTrue = true;
        for (char c : firstWord) {
            if(c != ' '){
                isTrue = false;
                return 0;
            }
        }
        return 1;
    }

    private static void ChangingArrays(char vowel, char consonant, char[] firstWord) {
        for (int i = 0; i < firstWord.length; i++) {
            if(firstWord[i] == vowel){
                firstWord[i] = ' ';
            }

            if(firstWord[i] == consonant){
                firstWord[i] = ' ';
            }
        }
    }

}
