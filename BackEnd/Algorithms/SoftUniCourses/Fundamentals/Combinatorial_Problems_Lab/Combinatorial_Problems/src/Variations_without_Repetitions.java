import java.util.Scanner;

public class Variations_without_Repetitions {
    public static boolean [] used;
    public static String [] massiveToFill;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] massive = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        used = new boolean[massive.length];
        massiveToFill = new String[n];
        Variation(massive , 0);
    }

    private static void Variation(String[] massive, int index) {
        if(index == massiveToFill.length){
            print(massiveToFill);
            return;
        }
        for (int i = 0; i < massive.length; i++) {
            if(!used[i]){
                used[i] = true;
                massiveToFill[index] = massive[i];
                Variation(massive , index+1);
                used[i] = false;
            }
        }
    }

    private static void print(String[] k) {
        System.out.println(String.join(" ",k));
    }
}
