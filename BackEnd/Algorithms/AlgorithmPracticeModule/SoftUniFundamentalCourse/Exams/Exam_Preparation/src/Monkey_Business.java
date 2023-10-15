import java.util.*;

public class Monkey_Business {

    public static int[] massive;
    public static int[] counts;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        massive = new int[n];
        counts = new int[1];



        CountSomething(0 , 1 );

        System.out.printf(String.format("Total Solutions: %d",counts[0]));
    }

    private static void CountSomething(int index, int start) {
        if(index >= massive.length){
            Add();
            return;
        }
            for (int i = start; i <= massive.length; i++) {
                massive[index] = i;
                CountSomething(index+1, i+1);
                massive[index] =-i;
                CountSomething(index+1, i+1);
            }
        }


    private static void Add() {
        StringBuilder print = new StringBuilder();
        int sum = Arrays.stream(massive).sum();
        if(sum == 0) {
            counts[0]++;
            for (int i = 0; i < massive.length; i++) {
                if (massive[i] > 0) {
                    print.append(String.format("+%s ", massive[i]));
                } else {
                    print.append(String.format("%s ", massive[i]));
                }
            }
            System.out.println(print.toString());
        }
    }
}
