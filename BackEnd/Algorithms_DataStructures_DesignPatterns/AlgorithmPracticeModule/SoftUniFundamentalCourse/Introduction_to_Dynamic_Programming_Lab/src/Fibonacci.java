import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size=  Integer.parseInt(scanner.nextLine());
        int [] dp = new int [size+1];
        Arrays.fill(dp , 1);

        for (int i = 2; i < size; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[size-1]);
    }
}
