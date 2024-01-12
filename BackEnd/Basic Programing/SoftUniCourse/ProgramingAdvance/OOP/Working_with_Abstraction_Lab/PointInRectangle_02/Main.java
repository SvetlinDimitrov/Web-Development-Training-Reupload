package JavaOOP.Working_with_Abstraction_Lab.PointInRectangle_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Rectangle rectangle = new Rectangle(arr[0],arr[1] ,arr[2], arr[3]);
        int times = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < times; i++) {
            arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(rectangle.contains(new Point(arr[0],arr[1])));
        }
    }
}
