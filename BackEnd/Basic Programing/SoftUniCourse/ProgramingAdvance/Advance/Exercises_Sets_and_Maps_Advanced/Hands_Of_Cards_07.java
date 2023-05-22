package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import JavaAdvance.Lab_Sets_and_Maps_Advanced.SoftUni_Party_02;

import java.util.*;

public class Hands_Of_Cards_07 {
    public static int sumAll;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> map = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String name = input.split(":")[0];
            String[] cards = input.split(": ")[1].split(", ");
            if (!map.containsKey(name)) {
                map.put(name, new HashSet<>());
                map.get(name).addAll(List.of(cards));
            } else {
                map.get(name).addAll(List.of(cards));
            }
            input = scanner.nextLine();
        }
        map.forEach((k, v) -> {
            sumAll = 0;
            v.forEach(e -> {
                int sum = 0;
                char firstCharacter = e.charAt(0);
                switch (firstCharacter) {
                    case 'J':
                        sum += 11;
                        break;
                    case 'Q':
                        sum += 12;
                        break;
                    case 'K':
                        sum += 13;
                        break;
                    case 'A':
                        sum += 14;
                        break;
                    default:
                        sum += Integer.parseInt(firstCharacter + "");
                        break;
                }
                char secondCharacter = e.charAt(1);
                switch (secondCharacter) {
                    case 'S':
                        sum *= 4;
                        break;
                    case 'H':
                        sum *= 3;
                        break;
                    case 'D':
                        sum *= 2;
                        break;
                }
                sumAll+=sum;
            });
                    System.out.printf("%s: %d%n",k , sumAll);
        });
    }
}
