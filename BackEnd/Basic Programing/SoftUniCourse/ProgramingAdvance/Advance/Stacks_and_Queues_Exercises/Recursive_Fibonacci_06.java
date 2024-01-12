package JavaAdvance.Stacks_and_Queues_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Recursive_Fibonacci_06 {
    public static long copyNum [] ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fibo = Integer.parseInt(scanner.nextLine());
        copyNum = new long[fibo + 1];
        if (fibo > 2) {
            System.out.println(Fibo(fibo));
        }else{
            System.out.println(1);
        }
    }

    private static long Fibo( int n) {
        if(n < 2){
            return 1;
        }
        if(copyNum[n] != 0){
            return copyNum[n];
        }
        copyNum[n] = Fibo(n-1) + Fibo(n-2);
        return copyNum[n];
    }
}
