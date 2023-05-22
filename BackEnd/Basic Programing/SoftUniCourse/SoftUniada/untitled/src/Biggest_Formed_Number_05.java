import java.math.BigInteger;
import java.util.Scanner;

public class Biggest_Formed_Number_05 {
    static BigInteger answer = new BigInteger("-9223372036854775808");
    static String[] massive;
    static boolean[] used;
    static String[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        massive = input.split(" ");
        arr = new String[massive.length];
        used = new boolean[massive.length];
        permo(0);
        System.out.println(answer);
    }

    private static void permo(int index ) {
        if (index >= arr.length) {
            String currentNum = giveMeString(arr);
            BigInteger current = new BigInteger(currentNum);
            if (answer.compareTo(current) < 0) {
                answer = current;
            }
        }
        for (int i = 0; i < massive.length; i++) {
            if (!used[i]) {
                arr[index] = massive[i];
                used[i] = true;
                permo(index+1);
                used[i] = false;
            }
        }
    }
    private static String giveMeString(String[] arr) {
        StringBuilder word = new StringBuilder();
        for (String s : arr) {
            word.append(s);
        }
        return word.toString();
    }
}
