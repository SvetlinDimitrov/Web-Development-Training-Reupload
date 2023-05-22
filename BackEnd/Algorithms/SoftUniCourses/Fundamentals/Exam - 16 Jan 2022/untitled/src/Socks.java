import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] sock1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int [] sock2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        
    }
}
