import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Towers_of_Hanoi {
    public static ArrayDeque<Integer> source;
    public static ArrayDeque<Integer> destination;
    public static ArrayDeque<Integer> spare;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        source = new ArrayDeque<>();
        destination = new ArrayDeque<>();
        spare = new ArrayDeque<>();
        for (int i = n; i >= 1; i--) {
            source.push(i);
        }

        print();
        recursive(source, destination, spare , n);
    }

    private static void recursive(ArrayDeque<Integer> source, ArrayDeque<Integer> destination, ArrayDeque<Integer> spare, int disk) {
        if(disk == 1){
            destination.push(source.pop());
            print();
            //TODO:: Неразбирам това защо работи, прегледай пак кода след време
        }else {
            recursive(source , spare , destination , disk-1);
            recursive(source , destination , spare ,1);
            recursive(spare , destination , source , disk-1);
        }
    }
    private static void print() {
        System.out.printf("Source: %s%n", source.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.printf("Destination: %s%n", destination.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.printf("Spare: %s%n", spare.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println();
    }

}
