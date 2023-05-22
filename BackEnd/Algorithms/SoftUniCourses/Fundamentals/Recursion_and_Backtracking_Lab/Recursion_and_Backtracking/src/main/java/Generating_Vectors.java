import java.util.Scanner;

public class Generating_Vectors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] num = new int [n];
        RecursiveShit(num , num.length-1);
    }

    private static void RecursiveShit(int[] num, int index) {
        if ( index < 0 ){
            Print(num);
            return;
        }

        for (int i = 0; i <= 1; i++) {

            num[index] = i;
            RecursiveShit(num , index-1);

        }

    }

    private static void Print(int[] num) {
        StringBuilder print = new StringBuilder();
        for (int i = num.length-1; i >= 0; i--) {
            print.append(String.format("%d",num[i]));

        }
        System.out.println(print.toString());
    }
}
