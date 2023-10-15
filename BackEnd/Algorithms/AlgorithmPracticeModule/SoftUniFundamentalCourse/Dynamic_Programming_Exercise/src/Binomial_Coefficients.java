import java.util.Scanner;

public class Binomial_Coefficients {
    public static long [][] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int cloe = Integer.parseInt(scanner.nextLine());
        arr = new long [row+2][cloe+2];
        arr[0][0] = 1;
        for (int i = 1; i <=row; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <= cloe; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        System.out.println(arr[row][cloe]);
    }
}
