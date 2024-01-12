package JavaAdvance.Exercises_Functional_Programming;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicate_Party_10_again {
    public static  int length;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();

        BiPredicate<String, String> StartsWith = (e, y) -> {
            int len = e.length();
            if (len > y.length()) {
                return false;
            }
            for (int i = 0; i < e.length(); i++) {
                if (e.charAt(i) != y.charAt(i)) {
                    return false;
                }
            }
            return true;
        };

        BiPredicate<String, String> EndsWith = (e, y) -> {
            int len = e.length();
            if (len > y.length()) {
                return false;
            }

            int count = e.length() - 1;
            for (int i = y.length() - 1; i > 0; i--) {
                if (y.charAt(i) != e.charAt(count)) {
                    return false;
                }
                count--;
                if (count == -1) {
                    break;
                }
            }
            return true;
        };

        BiPredicate<String, String> Length = (e, y) -> e.length() == y.length();

        while (!input.equals("Party!")) {
            String command = input.split(" ")[0];
            String firstName = input.split(" ")[1];
            String secondName = input.split(" ")[2];

            switch (command) {
                case "Remove":
                    switch (firstName) {
                        case "StartsWith":
                            names = Arrays.stream(names).filter(e -> !StartsWith.test(secondName, e))
                                    .toArray(String[]::new);
                            break;
                        case "EndsWith":
                            names = Arrays.stream(names).filter(e -> !EndsWith.test(secondName, e))
                                    .toArray(String[]::new);
                            break;

                        case "Length":
                            length = Integer.parseInt(secondName);
                            names = Arrays.stream(names).filter(e -> e.length() != length)
                                    .toArray(String[]::new);
                            break;
                    }

                    break;
                case "Double":
                    List<String> list = new LinkedList<>(Arrays.asList(names));
                    List<String> secondList = new LinkedList<>(Arrays.asList(names));
                    switch (firstName) {
                        case "StartsWith":
                            list.stream().filter(e -> StartsWith.test(secondName, e))
                                    .forEach(e -> {
                                        for (int i = 0; i < secondList.size(); i++) {
                                            if (secondList.get(i).equals(e)) {
                                                secondList.add(i, e);
                                                break;
                                            }
                                        }
                                    });
                            break;
                        case "EndsWith":
                            list.stream().filter(e -> EndsWith.test(secondName, e))
                                    .forEach(e -> {
                                        for (int i = 0; i < secondList.size(); i++) {
                                            if (secondList.get(i).equals(e)) {
                                                secondList.add(i, e);
                                                break;
                                            }
                                        }
                                    });
                            break;
                        case "Length":
                            length = Integer.parseInt(secondName);
                            list.stream().filter(e -> e.length() == length)
                                    .forEach(e -> {
                                        for (int i = 0; i < secondList.size(); i++) {
                                            if (secondList.get(i).equals(e)) {
                                                secondList.add(i, e);
                                                break;
                                            }
                                        }
                                    });
                            break;
                    }
                    names = secondList.stream().map(String::valueOf)
                            .toArray(String[]::new);


            }
            input = scanner.nextLine();

        }
        if (names.length == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
           System.out.printf("%s are going to the party!",Arrays.stream(names).collect(Collectors.joining(", ")));
        }
    }
}
