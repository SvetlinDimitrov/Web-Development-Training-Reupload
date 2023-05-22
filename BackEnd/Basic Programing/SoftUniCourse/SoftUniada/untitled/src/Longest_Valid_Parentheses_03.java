import java.util.ArrayDeque;
import java.util.Scanner;

public class Longest_Valid_Parentheses_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int current = 0;
        int answer = 0;
        ArrayDeque<Character> deck = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if(!deck.isEmpty()){
                if(input.charAt(i) == ')'){
                    current++;
                    deck.pop();
                }else{
                    current=0;
                }
            }
            if(input.charAt(i) == '(' && deck.isEmpty()){
                deck.push('(');
            }
            answer = Math.max(answer , current);
        }
        System.out.println(answer * 2);
    }
}
