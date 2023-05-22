import java.util.Scanner;

public class Permutations_without_Repetition {
//    public static String [] use;
//    public static boolean [] used;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] massive = scanner.nextLine().split(" ");
//        use = new String [massive.length];
//        used = new boolean[massive.length];
        Permutation(massive, 0);
    }

    private static void Permutation(String[] massive , int index) {
        if(index == massive.length){
            print(massive);
            return;
        }
        Permutation(massive , index+1);
        for (int i = index +1; i < massive.length; i++) {
            swap(massive, index ,i);
            Permutation(massive , index+1);
            unswap(massive, index ,i);
        }
    }

    private static void unswap(String[] massive, int i, int index) {
        String save = massive[index];
        massive[index] = massive[i];
        massive[i] = save;
    }

    private static void swap(String[] massive, int i, int index) {
        String save = massive[i];
        massive[i] = massive[index];
        massive[index] = save;
    }

    private static void print(String[] use) {
        System.out.println(String.join(" " , use));
    }
}
