
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        list.add(new ArrayList<>());
        list.get(1).add(1);
        list.get(1).add(1);

        for (int i = 2; i <= row; i++) {
            list.add(new ArrayList<>());
            list.get(i).add(1);
            for (int j = 1; j < list.get(i - 1).size(); j++) {
                list.get(i).add(list.get(i-1).get(j) + list.get(i-1).get(j-1));
            }
            list.get(i).add(1);
        }
        System.out.println(list.get(row).stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
