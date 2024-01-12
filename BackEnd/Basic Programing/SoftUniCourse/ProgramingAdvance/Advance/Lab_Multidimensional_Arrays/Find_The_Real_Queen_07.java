package JavaAdvance.Lab_Multidimensional_Arrays;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Find_The_Real_Queen_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] chessBoard = new String[8][8];


        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[i] = scanner.nextLine().split(" ");
        }


        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j].equals("q")) {
                    chessBoard[i] = FindQuin(chessBoard[i]);
                    if (IsTrue(chessBoard[i])) {
                        String[] horizontalArr = new String[chessBoard.length];
                        for (int k = 0; k < horizontalArr.length; k++) {
                            horizontalArr[k] = chessBoard[k][j];
                        }
                        horizontalArr = FindQuin(horizontalArr);
                        for (int k = 0; k < horizontalArr.length; k++) {
                            chessBoard[k][j] = horizontalArr[k];
                        }

                        if (IsTrue(chessBoard[i])) {
                            String[] diagonal1;
                            if (i > j) {
                                diagonal1 = new String[chessBoard[i].length - (i - j)];
                            } else {
                                diagonal1 = new String[chessBoard[i].length - (j - i)];
                            }
                            diagonal1 = DiagonalFill(diagonal1.length, chessBoard, i, j);
                            diagonal1 = FindQuin(diagonal1);
                            chessBoard = fillBoard(diagonal1, chessBoard, i, j);
                            if (IsTrue(diagonal1)) {
                                System.out.printf("%d %d%n" , i, j);
                            }
                        }

                    }
                }
            }
        }

    }

    private static String[][] fillBoard(String[] diagonal1, String[][] chess, int row, int cloe) {
        if (row > cloe) {
            int count = -1;
            for (int k = row - cloe; k < chess.length; k++) {
                count++;
                for (int l = count; l < chess[k].length; ) {
                    chess[k][count] = diagonal1[l];
                    break;
                }
            }
        } else {
            int count = cloe - row - 1;
            for (int k = 0; k < chess.length; k++) {
                count++;
                for (int l = cloe - row; l < chess[k].length; l++) {
                    if (count == l) {
                        chess[k][l] = diagonal1[k];
                        break;
                    }
                }
            }
        }
        return chess;

    }

    private static String[] DiagonalFill(int size, String[][] chessBoard, int row, int cloe) {
        String[] diagonal1 = new String[size];
        if (row > cloe) {
            int count = -1;
            for (int k = row - cloe; k < chessBoard.length; k++) {
                count++;
                for (int l = count; l < chessBoard[k].length; ) {
                    diagonal1[l] = chessBoard[k][count];
                    break;
                }
            }
        } else {
            int count = cloe - row - 1;
            for (int k = 0; k < chessBoard.length; k++) {
                count++;
                for (int l = cloe - row; l < chessBoard[k].length; l++) {
                    if (count == l) {
                        diagonal1[k] = chessBoard[k][l];
                        break;
                    }
                }
            }
        }
        return diagonal1;
    }

    private static boolean IsTrue(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("*")) {
                return false;
            }
        }
        return true;
    }

    private static String[] FindQuin(String[] arr) {
        int count = 1;
        HashMap<Integer, Integer> detected = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("q")) {
                count++;
                detected.put(count, i);
            }
        }
        if (detected.size() > 1) {
            return Change(arr);
        } else {
            return arr;
        }
    }

    private static String[] Change(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("q")) {
                arr[i] = "*";
            }
        }
        return arr;
    }
}
