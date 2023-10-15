import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stairs = Integer.parseInt(scanner.nextLine());
        long [] dp = new long[stairs+1];
        dp[1] = 1;
        dp[2] =2;
        for (int i = 3; i <= stairs; i++) {
            dp[i] = dp[i-1] + dp[i-2] ;


        }
        System.out.println(dp[stairs]);
    }
}
