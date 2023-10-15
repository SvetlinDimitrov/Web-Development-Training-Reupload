import java.util.Scanner;

public class Connected_Areas_in_Matrix {
    public static char [][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int cloe = Integer.parseInt(scanner.nextLine());
        matrix = new char [row][cloe];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != 'V' || matrix[i][j] != '*'){
                    solve(i , j);
                }
            }
        }
    }

    private static void solve(int row, int cloe) {
        if(ValidIndex(row , cloe) || matrix[row][cloe] == '*' || matrix[row][cloe] == 'V'){
            return;
        }
        matrix[row][cloe] = 'V';
        solve(row+1 ,cloe);
        solve(row-1 ,cloe);
        solve(row ,cloe+1);
        solve(row ,cloe-1);
    }

    private static boolean ValidIndex(int row, int cloe) {
        return row >= matrix.length || row<0 || cloe <0 || cloe>=matrix[row].length;
    }
}
