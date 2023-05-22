import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Nested_Loops_To_Recursion {
    public static int [] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        arr = new int[n];
        Permute(n, 0);
    }

    private static void Permute(int endGame, int index) {
        if(index >= endGame){
            System.out.println(Arrays.stream(arr)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 1; i <= endGame; i++) {
            arr[index] = i;
            Permute(endGame , index+1);
        }

    }
}
