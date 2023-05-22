package JavaAdvance.Exercises_Functional_Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Applied_Arithmetic_04_again_list {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> addFunction =
                nums->{
            List<Integer> toReturn = new ArrayList<>();
                    for (int i = 0; i < nums.size(); i++) {
                        toReturn.add(nums.get(i) + 1);
                    }
                    return toReturn;
                };

        UnaryOperator<List<Integer>> minusFunction =
                nums->{
                    List<Integer> toReturn = new ArrayList<>();
                    for (int i = 0; i < nums.size(); i++) {
                        toReturn.add(nums.get(i) - 1);
                    }
                    return toReturn;
                };

        UnaryOperator<List<Integer>> multiFunction =
                nums->{
                    List<Integer> toReturn = new ArrayList<>();
                    for (int i = 0; i < nums.size(); i++) {
                        toReturn.add(nums.get(i) + 1);
                    }
                    return toReturn;
                };



        String input = scanner.nextLine();

        while(!input.equals("end")){
            switch (input){
                case "add":
                    list = addFunction.apply(list);
                    break;
                case "multiply":
                    list = multiFunction.apply(list);
                    break;
                case "subtract":
                    list = minusFunction.apply(list);
                    break;
                case "print":
                    System.out.println(list.stream().map(Object::toString)
                            .collect(Collectors.joining(" ")));
                    break;

            }



            input = scanner.nextLine();
        }
    }
}
