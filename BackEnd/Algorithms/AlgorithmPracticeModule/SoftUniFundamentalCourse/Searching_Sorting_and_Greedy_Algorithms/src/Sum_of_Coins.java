import java.util.*;

public class Sum_of_Coins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getValue() + " -> " + usedCoin.getKey());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer , Integer> map = new LinkedHashMap<>();
        for (int i = coins.length-1; i >= 0; i--) {
            int key = targetSum / coins[i];
            if(key != 0) {
                map.put(coins[i], key);
            }
            targetSum-=key*coins[i];
            if(targetSum <= 0){
                break;
            }
        }
       return map;
    }
}