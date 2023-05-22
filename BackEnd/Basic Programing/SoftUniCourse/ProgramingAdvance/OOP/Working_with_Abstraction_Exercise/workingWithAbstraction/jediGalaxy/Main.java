package JavaOOP.Working_with_Abstraction_Exercise.workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] RawCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = RawCoordinates[0];
        int y = RawCoordinates[1];
        int[][] matrix = new int[x][y];

        fillMatrix(x, y, matrix);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int xE = evil[0];
            int yE = evil[1];

            while (xE >= 0 && yE >= 0) {
                if (xE >= 0 && xE < matrix.length && yE >= 0 && yE < matrix[0].length) {
                    matrix[xE][yE] = 0;
                }
                xE--;
                yE--;
            }

            int xI = ivoS[0];
            int yI = ivoS[1];

            while (xI >= 0 && yI < matrix[1].length) {
                if (xI >= 0 && xI < matrix.length && yI >= 0 && yI < matrix[0].length) {
                    sum += matrix[xI][yI];
                }

                yI++;
                xI--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static void fillMatrix(int x, int y, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
