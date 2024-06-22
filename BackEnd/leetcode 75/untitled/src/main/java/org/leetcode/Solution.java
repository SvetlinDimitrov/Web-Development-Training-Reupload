package org.leetcode;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
 *
 */
public class Solution
{
  public static int[]  funcSort(int[] inputList, int num)
  {
    int[]  answer = new int[inputList.length];
    Set<Integer> usedNums = new HashSet<>();
    for (int i = 0; i < inputList.length; i++) {
      if (num > i) {
        answer[i] = findTheMinNum(inputList, 0, num, usedNums);
      } else {
        answer[i] = findTheLargestNum(inputList, num, inputList.length, usedNums);
      }
      usedNums.add(answer[i]);
    }
    return answer;

  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    //input for inputList
    int inputList_size = in.nextInt();
    int inputList[] = new int[inputList_size];
    for(int idx = 0; idx < inputList_size; idx++)
    {
      inputList[idx] = in.nextInt();
    }
    // input for num
    int num = in.nextInt();


    int[] result = funcSort(inputList, num);
    for(int idx = 0; idx < result.length - 1; idx++)
    {
      System.out.print(result[idx] + " ");
    }
    System.out.print(result[result.length - 1]);
  }

  public static int findTheLargestNum(int[] arr, int start, int end, Set<Integer> usedNums) {
    int max = Integer.MIN_VALUE;
    for (int i = start; i < end; i++) {
      if (usedNums.contains(arr[i])) continue;
      max = Math.max(max, arr[i]);
    }
    return max;
  }

  public static int findTheMinNum(int[] arr, int start, int end, Set<Integer> usedNums) {
    int max = Integer.MAX_VALUE;
    for (int i = start; i < end; i++) {
      if (usedNums.contains(arr[i])) continue;
      max = Math.min(max, arr[i]);
    }
    return max;
  }

}
