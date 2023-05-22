package JavaAdvance.Lab_Sets_and_Maps_Advanced;

import java.util.*;
import java.util.stream.Collectors;

public class Voina_Number_Game_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int rounds = 0;
        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            rounds++;
            if (rounds == 50) {
                break;
            }
            Iterator<Integer> first = firstPlayer.iterator();
            int firstCard = first.next();
            first.remove();

            Iterator<Integer> second = secondPlayer.iterator();
            int secondCard = second.next();
            second.remove();

            if(firstCard > secondCard){
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            }else {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }
        }
        if(secondPlayer.size()> firstPlayer.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("First player win!");
        }
    }
}
