import java.util.Scanner;

public class N_ChooseK_Count {
    public static long arr[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        System.out.println(Pascal(n ,k));

    }

    private static long Pascal(int n, int k) {
        if(n < 0 || k < 0) {
            return 0;
        }
        if( k == n ){
            return 1;
        }
        return Pascal(n -1 , k-1 )+ Pascal(n-1 , k);
    }
}
