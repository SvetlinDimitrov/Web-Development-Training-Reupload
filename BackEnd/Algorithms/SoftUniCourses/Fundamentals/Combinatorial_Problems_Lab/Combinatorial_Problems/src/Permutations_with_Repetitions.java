import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Permutations_with_Repetitions {
    public static Set <String> set;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] massive = scanner.nextLine().split(" ");
        set = new HashSet<>();
        PermutationMethod(massive, 0);
        for (String string : set) {
            System.out.println(string);
        }
    }

    private static void PermutationMethod(String[] massive, int index) {
        if(index == massive.length){
            set.add(String.join(" ",massive));
            return;
        }
        PermutationMethod(massive , index+1);
        for (int i = index+1; i < massive.length; i++) {
            swap(massive , i , index);
            PermutationMethod(massive , index+1);
            unswap(massive , i , index);
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
}
