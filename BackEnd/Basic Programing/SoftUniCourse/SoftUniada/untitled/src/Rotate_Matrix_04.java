import java.util.Arrays;
import java.util.Scanner;

public class Rotate_Matrix_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int [n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int [][] answer = new int [n][n];
        for (int row = 0; row < n; row++) {
            for (int cloe = 0; cloe < n; cloe++) {
                answer[cloe][n-1-row] = matrix[row][cloe];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d " , answer[i][j]);
            }
            System.out.println();
        }
    }
}
