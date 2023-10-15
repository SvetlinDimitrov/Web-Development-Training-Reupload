import java.util.Scanner;

public class Recursive_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        long [] masive = new long [num+1];
        System.out.println(Fibonachi(num , masive));

    }

    private static long Fibonachi(int index, long[] masive) {

        if(index <= 1) {
            return 1;
        }else if(masive[index] != 0){
            return masive[index];
        }

        masive[index] =  Fibonachi(index-1, masive) + Fibonachi(index-2, masive);
        return masive[index];
    }
}