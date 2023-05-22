import java.util.Scanner;

public class Variations_with_Repetition {
    public static String [] arrayToFill;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] arr = scanner.nextLine().split(" ");
        int i = Integer.parseInt(scanner.nextLine());
        arrayToFill = new String [i];
        Variate(arr , 0);
    }

    private static void Variate(String[] arr, int index) {
        if(arrayToFill.length == index){
            print(arrayToFill);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arrayToFill[index] = arr[i];
            Variate(arr , index +1);
        }
    }

    private static void print(String[] arrayToFill) {
        System.out.println(String.join(" ",arrayToFill));
    }
}
