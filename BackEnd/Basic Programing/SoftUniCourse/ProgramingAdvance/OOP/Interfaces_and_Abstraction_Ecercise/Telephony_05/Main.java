import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] numbers = scanner.nextLine().split("\\s+");
        String [] urls = scanner.nextLine().split("\\s+");
        Smartphone smart = new Smartphone(Arrays.stream(numbers).collect(Collectors.toList()),Arrays.stream(urls).collect(Collectors.toList()));
        System.out.print(smart.call());
        System.out.print(smart.browse());
    }
}
