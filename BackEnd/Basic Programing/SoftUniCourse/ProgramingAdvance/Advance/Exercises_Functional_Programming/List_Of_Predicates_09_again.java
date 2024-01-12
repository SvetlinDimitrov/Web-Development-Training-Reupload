package JavaAdvance.Exercises_Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class List_Of_Predicates_09_again {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] arr = new int [n];
        for (int i = 1; i <=n ; i++) {
            arr[i-1]=i;
        }

        int [] allPredicates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int allPredicate : allPredicates) {
            arr = Arrays.stream(arr).filter(e->e % allPredicate == 0)
                    .toArray();
        }

        Arrays.stream(arr).forEach(e->System.out.printf("%d ",e));
    }
}
