package org.leetcode.HashMapSet;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {

  /*
  Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

  Example 1:
  Input: arr = [1,2,2,1,1,3]
  Output: true
  Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

  Example 2:
  Input: arr = [1,2]
  Output: false

  Example 3:
  Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
  Output: true
  * */
  public static void main(String[] args) {
    int[] arr = {1, 2, 2, 1, 1, 3}, arr2 = {1, 2}, arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
    System.out.println(uniqueOccurrences(arr));
    System.out.println(uniqueOccurrences(arr2));
    System.out.println(uniqueOccurrences(arr3));
  }

  public static boolean uniqueOccurrences(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : arr) {
      map.putIfAbsent(num, 0);
      map.put(num, map.get(num) + 1);
    }

    HashSet<Integer> answer = new HashSet<>(map.values());
    return answer.size() == map.size();
  }
}
