import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Find_All_Paths_in_a_Labyrinth {
    static List<Character> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int cloe = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[row][cloe];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        FindAllPaths(matrix, 0, 0, ' ');
    }

    private static void FindAllPaths(char[][] matrix, int row, int cloe, char theWay) {
        if (IndexInvalid(matrix, row, cloe) || matrix[row][cloe] == '*' || matrix[row][cloe] == 'V') {
            return;
        }else if (matrix[row][cloe] == 'e') {
            list.add(theWay);
            System.out.println(
                    list.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("")).trim());
            list.remove(list.size() - 1);
            return;

        }else{
            list.add(theWay);
            matrix[row][cloe] = 'V';
        }

        FindAllPaths(matrix, row, cloe + 1, 'R');
        FindAllPaths(matrix, row - 1, cloe, 'U');
        FindAllPaths(matrix, row + 1, cloe, 'D');
        FindAllPaths(matrix, row, cloe - 1, 'L');

        list.remove(list.size() - 1);
        matrix[row][cloe] = '-';


    }

    private static boolean IndexInvalid(char[][] matrix, int row, int cloe) {
        return row >= matrix.length || row < 0 || cloe >= matrix[row].length || cloe < 0;
    }
}
