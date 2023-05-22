import java.util.Scanner;

public class Recursive_Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine());
        System.out.println(Facturiel(n));
    }

    private static long Facturiel(long n) {
        if(n == 1){
            return 1;
        }
        return n * Facturiel(n-1);
    }
}
