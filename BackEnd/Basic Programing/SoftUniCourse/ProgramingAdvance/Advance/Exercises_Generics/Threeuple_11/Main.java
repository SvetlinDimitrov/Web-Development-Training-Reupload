package JavaAdvance.Exercises_Generics.Threeuple_11;

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
        tuple.setTown(arr[3]);
        arr = scanner.nextLine().split(" ");
        tuple.setName(arr[0]);
        tuple.setLitersOfBeer(Integer.parseInt(arr[1]));
        tuple.setDrunkOrNot(arr[2]);
        arr = scanner.nextLine().split(" ");
        tuple.setNameAgin(arr[0]);
        tuple.setAccBalance(Double.parseDouble(arr[1]));
        tuple.setBankName(arr[2]);
        System.out.println(tuple);

    }
}
