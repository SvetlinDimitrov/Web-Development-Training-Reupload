import java.util.Arrays;
import java.util.Scanner;

public class Sum_with_Unlimited_Amount_of_Coins {
  
    public static int [] combinations;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coins = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(scanner.nextLine());
        
        combinations = new int[sum + 1];
        combinations[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= sum ; j++) {
                int index = j - coins[i];
                combinations[j] += combinations[index];
            }
        }
    }
}
