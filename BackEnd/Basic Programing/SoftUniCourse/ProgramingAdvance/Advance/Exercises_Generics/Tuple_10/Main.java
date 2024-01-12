package JavaAdvance.Exercises_Generics.Tuple_10;

import java.util.Scanner;

public class Main {
    public static String [] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr = scanner.nextLine().split(" ");
        Tuple tuple = new Tuple();
        tuple.setFirstName(arr[0]);
        tuple.setLastName(arr[1]);
        tuple.setAddress(arr[2]);
        arr = scanner.nextLine().split(" ");
        tuple.setName(arr[0]);
        tuple.setLitersOfBeer(Integer.parseInt(arr[1]));
        arr = scanner.nextLine().split(" ");
        tuple.setInteger(Integer.parseInt(arr[0]));
        tuple.setDoublee(Double.parseDouble(arr[1]));
        System.out.println(tuple);

    }
}
