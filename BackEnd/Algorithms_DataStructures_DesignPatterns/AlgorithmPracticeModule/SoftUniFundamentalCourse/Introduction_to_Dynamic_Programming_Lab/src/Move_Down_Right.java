import java.util.*;
import java.util.stream.Collectors;

public class Move_Down_Right {
    public static int [][] matrixCopy ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int cloe = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[row][cloe];
        matrixCopy = new int [row][cloe];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int i = 0; i < matrixCopy.length; i++) {
            for (int j = 0; j < matrixCopy[i].length; j++) {
                if(i==0 && j ==0){
                    matrixCopy[i][j] = matrix[i][j];
                }else if(i == 0){
                    matrixCopy[i][j] = matrix[i][j] + matrixCopy[i][j-1];
                }else if( j == 0){
                    matrixCopy[i][j] = matrixCopy[i-1][j] + matrix[i][j];
                }else{
                    int betterValue = Math.max(matrixCopy[i-1][j] , matrixCopy[i][j-1]);
                    matrixCopy[i][j] = betterValue + matrix[i][j];
                }
            }
        }
        List<String> path = new ArrayList<>();
        row = matrix.length-1;
        cloe = matrix[row].length-1;
        while(row >= 0 && cloe >= 0){
            if(row == 0){
                path.add(String.format("[%d, %d]",row , cloe));
                cloe --;
                continue;
            }
            if(cloe== 0){
                path.add(String.format("[%d, %d]",row , cloe));
                row--;
                continue;
            }
            if(matrixCopy[row][cloe-1] < matrixCopy[row-1][cloe]){
                path.add(String.format("[%d, %d]",row , cloe));
                row--;
            }else {
                path.add(String.format("[%d, %d]",row , cloe));
                cloe--;
            }
        }
        Collections.reverse(path);
        System.out.println(path.stream().collect(Collectors.joining(" ")));
    }
}
