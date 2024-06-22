package org.leetcode.TwoPointers;

import java.util.Arrays;

public class MoveZeroes {

  /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:
    Input: nums = [0]
    Output: [0]
  * */

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void moveZeroes(int[] nums) {
    int f = 0;

    while (f < nums.length) {

      if (nums[f] == 0) {
        int s = f + 1;
        while (s < nums.length && nums[s] == 0) {
          s++;
        }
        if (s < nums.length && nums[s] != 0) {
          int saved = nums[f];
          nums[f] = nums[s];
          nums[s] = saved;
        }
      }
      f++;
    }
  }
}
