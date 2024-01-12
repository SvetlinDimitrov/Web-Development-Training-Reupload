package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Applied_Arithmetic_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = num-> num.stream().map(e -> e+1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = num-> num.stream().map(e -> e*2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = num-> num.stream().map(e -> e-1).collect(Collectors.toList());
        Consumer<List<Integer>> print = num-> num.forEach(e->System.out.printf("%d ",e));

        String input = scanner.nextLine();
        while(!input.equals("end")){
            switch (input){
                case "add":
                   arr = add.apply(arr);
                    break;
                case "print":
                    print.accept(arr);
                    System.out.println();
                    break;
                case "multiply":
                    arr = multiply.apply(arr);
                    break;
                case "subtract":
                    arr = subtract.apply(arr);
                    break;
            }


            input = scanner.nextLine();
        }
    }
}
