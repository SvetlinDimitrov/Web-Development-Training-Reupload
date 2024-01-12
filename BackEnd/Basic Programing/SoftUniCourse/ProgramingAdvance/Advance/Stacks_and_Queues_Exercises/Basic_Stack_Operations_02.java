package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.*;

public class Basic_Stack_Operations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberIntegers = scanner.nextInt();
        int deleteElements = scanner.nextInt();
        int checkElement = scanner.nextInt();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numberIntegers; i++) {
            numbers.push(scanner.nextInt());
        }

        for (int i = 0; i < deleteElements; i++) {
            numbers.pop();
        }

        if(numbers.contains(checkElement)){
            System.out.println("true");
        }else if (numbers.isEmpty()){
            System.out.println(0);
        }else{
            int smallestNum = Collections.min(numbers);
            System.out.println(smallestNum);
        }
    }
}
