import java.util.Scanner;

public class TBC {
    public static char [][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int cloe = Integer.parseInt(scanner.nextLine());
        matrix = new char [row][cloe];
        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 't'){
                    count++;
                    dfs(i , j);

                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int row, int cloe) {
        if(isNotValidIndex(row , cloe) || matrix[row][cloe] != 't'){
            return;
        }
        matrix[row][cloe] = '?';
        dfs(row+1 , cloe);
        dfs(row-1 , cloe);
        dfs(row , cloe+1);
        dfs(row, cloe-1);

        dfs(row+1 , cloe+1);
        dfs(row+1 , cloe-1);
        dfs(row -1 , cloe+1);
        dfs(row-1, cloe-1);

    }

    private static boolean isNotValidIndex(int row, int cloe) {
        return row >= matrix.length || row < 0  || cloe >= matrix[row].length || cloe < 0;
    }
}
