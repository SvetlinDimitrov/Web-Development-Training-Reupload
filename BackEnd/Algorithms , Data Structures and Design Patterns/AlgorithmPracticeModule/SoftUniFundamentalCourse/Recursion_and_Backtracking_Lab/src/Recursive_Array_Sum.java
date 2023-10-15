import java.util.Arrays;
import java.util.Scanner;

public class Recursive_Array_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(RecursiveSum(num, 0));
    }

    private static int RecursiveSum(int[] num, int index) {
        if (index  >= num.length) {
            return 0;
        }

        return num[index] + RecursiveSum(num, index + 1);
    }
}
