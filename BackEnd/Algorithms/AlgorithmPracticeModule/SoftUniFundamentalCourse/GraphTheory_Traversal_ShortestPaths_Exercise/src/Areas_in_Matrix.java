import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Areas_in_Matrix {
    public static Map<Character , Integer> map = new TreeMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char [size][size];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != '?'){
                    map.putIfAbsent(matrix[i][j] , 0);
                    map.put(matrix[i][j] , map.get(matrix[i][j]) + 1);
                    dfs(matrix , i , j , matrix[i][j]);
                }
            }
        }
        System.out.printf("Areas: %d%n",map.values().stream()
                .mapToInt(e->e)
                .sum());
        for (Character character : map.keySet()) {
            System.out.printf("Letter '%c' -> %d%n",character , map.get(character));
        }

    }

    private static void dfs(char[][] matrix, int row, int cloe, char c) {
        if(!itsValid(matrix , row , cloe)){
            return;
        }
        if(matrix[row][cloe] == c && matrix[row][cloe] !='?') {
            matrix[row][cloe] = '?';
            dfs(matrix, row + 1, cloe, c);
            dfs(matrix, row - 1, cloe, c);
            dfs(matrix, row, cloe + 1, c);
            dfs(matrix, row, cloe - 1, c);
        }
    }

    private static boolean itsValid(char[][] matrix, int row, int cloe) {
        return row >= 0 && row<=matrix.length-1 && cloe >=0 && cloe <= matrix[0].length-1;
    }
}
