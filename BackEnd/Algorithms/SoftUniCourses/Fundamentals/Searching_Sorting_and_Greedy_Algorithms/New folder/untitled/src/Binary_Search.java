import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());



        System.out.println(BiniarySearch(num, n));
    }

    private static int BiniarySearch(int[] num, int n) {

        int start = 0;
        int end = num.length-1;

        while(end > 0 && start <= end){
            int middle = (start + end)/2;
            if(num[middle] > n){
               end = middle -1 ;
            }else if(num[middle] < n){
                start = middle +1;
            }else if(num[middle] == n){
                return middle;
            }
        }
        return -1;
    }
}
