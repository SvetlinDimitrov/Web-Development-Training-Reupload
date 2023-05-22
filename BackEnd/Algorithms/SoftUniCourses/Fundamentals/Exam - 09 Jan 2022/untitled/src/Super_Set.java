import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Super_Set {
    public static int[] arr;
    public static int[] helper;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Permutate(0 , 1 , 0 );
    }

    private static void Permutate(int index, int restriction, int start) {
        if(restriction >= arr.length){
            return;
        }
        if(restriction <= index){
            Print(helper);
            return;
        }
        if(index == 0) {
            helper = new int[restriction];
        }
        for (int i = start; i < arr.length; i++) {

            helper[index] = arr[i];
            Permutate(i+1 , restriction, start+1);
        }
        Permutate( index , restriction +1, 0);
    }

    private static void Print(int[] index) {
        System.out.println(Arrays.stream(index).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
