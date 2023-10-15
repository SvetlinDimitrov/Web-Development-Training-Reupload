import java.util.*;
import java.util.stream.Collectors;

public class Climbing {
    public static int [][] arr;
    public static int [][] fixed;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int cloe = Integer.parseInt(scanner.nextLine());

        arr = new int [row][cloe];


        for (int i = 0; i < row; i++) {
            arr[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        fixed = new int [row][cloe];
        fixed[0][0] = arr[0][0];

        //fix row
        for (int i = 1; i < fixed[0].length; i++) {
            fixed[0][i] = fixed[0][i-1] + arr[0][i];
        }
        //fix cloe
        for (int i = 1; i < fixed.length; i++) {
            fixed[i][0] = fixed[i-1][0] + arr[i][0];
        }

        for (int i = 1; i < fixed.length; i++) {
            for (int j = 1; j < fixed[i].length; j++) {
                int sumUp = fixed[i-1][j] + arr[i][j];
                int sumLeft = fixed[i][j-1] + arr[i][j];
                if(sumUp >= sumLeft){
                    fixed[i][j] = sumUp;
                }else{
                    fixed[i][j] = sumLeft;
                }
            }
        }
        ArrayList<Integer> nums = new ArrayList<>();
        row = 0;
        cloe = 0;
        while(row < fixed.length-1 || cloe < fixed[0].length-1){
            nums.add(arr[row][cloe]);
            if(row == fixed.length-1){
                cloe++;
            }else if (cloe == fixed[0].length-1){
                row++;
            }else if (fixed[row][cloe+1] > fixed[row+1][cloe]){
                cloe++;
            }else {
                row++;
            }
        }
        nums.add(arr[arr.length-1][arr[0].length-1]);
        Collections.reverse(nums);
        System.out.println(fixed[arr.length-1][arr[0].length-1]);
        System.out.println(nums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
