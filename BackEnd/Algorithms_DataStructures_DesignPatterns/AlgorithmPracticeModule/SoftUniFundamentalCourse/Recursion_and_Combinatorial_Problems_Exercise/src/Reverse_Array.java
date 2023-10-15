import java.util.Scanner;

public class Reverse_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] array = scanner.nextLine().split(" ");
        System.out.println(RecursionRevurse(array , array.length-1));
    }

    private static String RecursionRevurse(String[] array, int index) {
        StringBuilder print = new StringBuilder();
        String format = String.format("%s ",array[index]);

        print.append(format);
        if(index <= 0){
            return print.toString();
        }

        return print.append(RecursionRevurse(array , index-1)).toString();
    }
}
