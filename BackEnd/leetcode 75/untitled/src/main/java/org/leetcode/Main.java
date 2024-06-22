package org.leetcode;

import java.util.Scanner;

public class Main {
  public static int[][] closestDistance(int[][] aerialView) {
    int[][] answer = new int[aerialView.length][aerialView[0].length];

    for (int i = 0; i < aerialView.length; i++) {
      for (int j = 0; j < aerialView[0].length; j++) {
        if (aerialView[i][j] == 1) {
          answer[i][j] = 0;
        } else {
          answer[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    for (int i = 0; i < aerialView.length; i++) {
      for (int j = 0; j < aerialView[i].length; j++) {
        if (isPreserverNearby(aerialView, i, j) && aerialView[i][j] != 1) {
          answer[i][j] = 1;
        }
      }
    }


    for (int i = 0; i < aerialView.length; i++) {
      for (int j = 0; j < aerialView[i].length; j++) {
        if (answer[i][j] == Integer.MAX_VALUE) answer[i][j] = findClosestDistance(answer, i, j) + 1;

      }
    }
    return answer;
  }

  private static int findClosestDistance(int[][] aerialView, int i, int j) {
    int distance = Integer.MAX_VALUE;

    if (i - 1 >= 0 && aerialView[i - 1][j] != 0) {
      distance = Math.min(distance, aerialView[i - 1][j]);
    }
    if (i + 1 < aerialView.length && aerialView[i + 1][j] != 0) {
      distance = Math.min(distance, aerialView[i + 1][j]);
    }
    if (j - 1 >= 0 && aerialView[i][j - 1] != 0) {
      distance = Math.min(distance, aerialView[i][j - 1]);
    }
    if (j + 1 < aerialView[0].length && aerialView[i][j + 1] != 0) {
      distance = Math.min(distance, aerialView[i][j + 1]);
    }
    return distance == Integer.MAX_VALUE ? 0 : distance;
  }

  private static boolean isPreserverNearby(int[][] aerialView, int i, int j) {
    if (i - 1 >= 0 && aerialView[i - 1][j] == 1) {
      return true;
    }
    if (i + 1 < aerialView.length && aerialView[i + 1][j] == 1) {
      return true;
    }
    if (j - 1 >= 0 && aerialView[i][j - 1] == 1) {
      return true;
    }
    if (j + 1 < aerialView[0].length && aerialView[i][j + 1] == 1) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // input for aerialView
    int aerialView_row = in.nextInt();
    int aerialView_col = in.nextInt();
    int aerialView[][] = new int[aerialView_row][aerialView_col];
    for (int idx = 0; idx < aerialView_row; idx++) {
      for (int jdx = 0; jdx < aerialView_col; jdx++) {
        aerialView[idx][jdx] = in.nextInt();
      }
    }

    int[][] result = closestDistance(aerialView);
    for (int idx = 0; idx < result.length; idx++) {
      for (int jdx = 0; jdx < result[0].length - 1; jdx++) {
        System.out.print(result[idx][jdx] + " ");
      }
      System.out.print(result[idx][result[0].length - 1]);
      System.out.println();
    }
  }
}