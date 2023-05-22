import java.util.Scanner;

public class Combinations_without_Repetition {
    public static String [] massiveToFill;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] massive = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        massiveToFill = new String [n];
        Combination(massive , 0 , 0);
    }

    private static void Combination(String[] massive, int index, int start) {
        if(massiveToFill.length <= index){
            print();
            return;
        }
        for (int i = start; i <massive.length; i++) {
            massiveToFill[index] = massive[i];
            Combination(massive , index+1, i);
        }
    }

    private static void print() {
        System.out.println(String.join(" ", massiveToFill));
    }
}
