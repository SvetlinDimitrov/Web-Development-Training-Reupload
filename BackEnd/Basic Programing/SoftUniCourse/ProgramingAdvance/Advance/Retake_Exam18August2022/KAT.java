package JavaAdvance.Exams.Java_Advanced_Retake_Exam18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer>tail = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tail::offerLast);

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stack::push);
        int carsRegister=0;
        int days = 0;

        while(!tail.isEmpty() && !stack.isEmpty()){
            days++;
            int license = tail.poll();
            int cars = stack.pop();
            if(cars *2 >license){
                carsRegister +=license/2;
                cars = cars - license/2;
                stack.offerLast(cars);
            }else if (cars*2 == license){
                carsRegister += cars;
            }else{
                carsRegister += cars;
                license = license - cars*2;
                tail.offerLast(license);
            }
        }
        System.out.printf("%d cars were registered for %d days!%n",carsRegister,days);
        if(!tail.isEmpty()){
            System.out.printf("%d license plates remain!%n",tail.stream().mapToInt(e->e).sum());
        } else if(!stack.isEmpty()){
            System.out.printf("%d cars remain without license plates!%n",stack.stream().mapToInt(e->e).sum());
        } else{
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

    }
}
