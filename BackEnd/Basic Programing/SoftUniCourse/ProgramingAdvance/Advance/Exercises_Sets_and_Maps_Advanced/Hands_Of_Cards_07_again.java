package JavaAdvance.Exercises_Sets_and_Maps_Advanced;

import java.util.*;

public class Hands_Of_Cards_07_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> map = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String halfInput = input.split(": ")[1];
            String[] cards = halfInput.split(", ");
            map.putIfAbsent(name, new HashSet<>());
            Arrays.stream(cards).forEach(e -> map.get(name).add(e));
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> print : map.entrySet()) {
            System.out.printf("%s: ", print.getKey());
            int sum = 0;
            for (String s : print.getValue()) {
                int num1 = 0;
                int num2 = 0;


                switch (s.charAt(0)) {
                    case '2':
                        num1 = 2;
                        break;
                    case '3':
                        num1 = 3;
                        break;
                    case '4':
                        num1 = 4;
                        break;
                    case '5':
                        num1 = 5;
                        break;
                    case '6':
                        num1 = 6;
                        break;
                    case '7':
                        num1 = 7;
                        break;
                    case '8':
                        num1 = 8;
                        break;
                    case '9':
                        num1 = 9;
                        break;
                    case '1':
                        num1 = 10;
                        break;
                    case 'J':
                        num1 = 11;
                        break;
                    case 'Q':
                        num1 = 12;
                        break;
                    case 'K':
                        num1 = 13;
                        break;
                    case 'A':
                        num1 = 14;
                        break;
                }
                if (s.charAt(0) == '1') {
                    switch (s.charAt(2)) {
                        case 'S':
                            num2 = 4;
                            break;
                        case 'H':
                            num2 = 3;
                            break;
                        case 'D':
                            num2 = 2;
                            break;
                        case 'C':
                            num2 = 1;
                            break;
                    }
                } else {
                    switch (s.charAt(1)) {
                        case 'S':
                            num2 = 4;
                            break;
                        case 'H':
                            num2 = 3;
                            break;
                        case 'D':
                            num2 = 2;
                            break;
                        case 'C':
                            num2 = 1;
                            break;
                    }

                }
                sum += num1 * num2;

            }
            System.out.printf("%d%n", sum);
        }
    }
}
