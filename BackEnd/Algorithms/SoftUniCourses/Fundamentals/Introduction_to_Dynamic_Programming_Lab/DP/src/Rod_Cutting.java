import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Rod_Cutting {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] prices = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sizeOfTheRope = Integer.parseInt(scanner.nextLine());
        int maxSum = 0;
        if(sizeOfTheRope >= prices.length) {
            maxSum = findingBestPrice(prices, sizeOfTheRope);
        }else{
            while(sizeOfTheRope >0){
                maxSum += findingBestPrice(prices, sizeOfTheRope);
                sizeOfTheRope=-prices.length;
            }
        }
        System.out.println(maxSum);
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static int findingBestPrice(int[] prices, int sizeOfTheRope) {
        int maxSum = 0;
        for (int i = 1; i < prices.length; i++) {
            if(i == sizeOfTheRope){
                if(prices[i] >= maxSum){
                    maxSum = prices[i];
                    list.clear();
                    list.add(i);
                }
                break;
            }


            for (int j = 1; j < prices.length ; j++) {
                if(i + j == sizeOfTheRope){
                    if(prices[i] + prices[j] >= maxSum){
                        maxSum = prices[i] + prices[j];
                        list.clear();
                        list.add(i);
                        list.add(j);
                    }
                    break;
                }

            }

        }
        return maxSum;
    }
}
