package org.leetcode.HashMapSet;

import java.util.LinkedList;
import java.util.Queue;

public class EqualRowAndColumnPairs {

  /*
  Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

  A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

  Example 1:
  Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
  Output: 1
  Explanation: There is 1 equal row and column pair:
  - (Row 2, Column 1): [2,7,7]

  Example 2:
  Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
  Output: 3
  Explanation: There are 3 equal row and column pairs:
  - (Row 0, Column 0): [3,1,2,2]
  - (Row 2, Column 2): [2,4,2,2]
  - (Row 3, Column 2): [2,4,2,2]
  * */

  public static void main(String[] args) {
    int[][] matrix = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
    System.out.println(equalPairs(matrix));
    int[][] matrix2 = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
    System.out.println(equalPairs(matrix2));
  }

  public static int equalPairs(int[][] grid) {
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();

    for (int[] ints : grid) {
      for (int j = 0; j < ints.length; j++) {
        boolean addValue = true;
        int vi = 0;

        while (vi < grid.length) {
          queue.offer(grid[vi][j]);
          vi++;
        }

        int vj = 0;

        while (vj < grid[0].length) {
          int num = ints[vj];
          if (num != queue.poll()) {
            addValue = false;
            break;
          }

          vj++;
        }

        queue.clear();

        if (addValue) answer++;
      }
    }

    return answer;
  }
}
