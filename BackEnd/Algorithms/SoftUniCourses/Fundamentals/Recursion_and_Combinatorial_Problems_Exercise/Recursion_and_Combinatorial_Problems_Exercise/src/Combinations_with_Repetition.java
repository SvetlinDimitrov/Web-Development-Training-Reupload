import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Combinations_with_Repetition {
    public static int[] combination;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        combination = new int [n];
        combinationMagic(k,0 , 1);

    }

    private static void combinationMagic(int k, int index, int startIndex) {
        if( index >= combination.length ){
            print();
            return;
        }

        for (int i = startIndex; i <= k; i++) {
            combination[index] = i;
            combinationMagic(k , index +1 , i);
        }
    }

    private static void print() {
        System.out.println(Arrays.stream(combination)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
