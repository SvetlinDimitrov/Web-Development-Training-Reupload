import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class School_Teams {
    public static String [] girls;
    public static String [] boys;
    public static String [] massive;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        girls = scanner.nextLine().split(", ");
        boys = scanner.nextLine().split(", ");
        massive = new String[5];
        solve(0,0  , 0);
    }

    private static void solve(int index , int startGirl ,int startBoys) {
        if (index >= 5) {
            print();
        } else if (index >= 3) {
            for (int i = startBoys; i < boys.length; i++) {
                massive[index] = boys[i];
                solve(index + 1, startGirl, i + 1);
            }
        } else {
            for (int i = startGirl; i < girls.length; i++) {
                massive[index] = girls[i];
                solve(index + 1, i + 1, startBoys);
            }

        }
    }

    private static void print() {
        System.out.println(Arrays.stream(massive).collect(Collectors.joining(", ")));
    }
}
