package org.leetcode.ArrayString;

public class IncreasingTripletSubsequence {


  /*
    Given an integer array nums, return true if there exists a triple of indices (i, j, k)
    such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

    Example 1:
    Input: nums = [1,2,3,4,5]
    Output: true
    Explanation: Any triplet where i < j < k is valid.

    Example 2:
    Input: nums = [5,4,3,2,1]
    Output: false
    Explanation: No triplet exists.

    Example 3:
    Input: nums = [2,1,5,0,4,6]
    Output: true
    Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
  * */
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    int[] nums2 = {5, 4, 3, 2, 1};
    int[] nums3 = {2, 1, 5, 0, 4, 6};
    int[] nums4 = {1, 5, 0, 4, 1, 3};
    System.out.println(increasingTriplet2(nums4));
  }

  //TODO:: OPTIZE THIS TO USE ONLY ONE LOOP
  public static boolean increasingTriplet(int[] nums) {
    int f = 0, s, t;

    while (f < nums.length) {

      s = f;

      while (s < nums.length) {
        if (nums[s] > nums[f]) {
          t = s;
          while (t < nums.length) {
            if (nums[f] < nums[s] && nums[s] < nums[t]) {
              return true;
            } else t++;
          }

        }
        s++;
      }

      f++;
    }

    return false;
  }

  //TODO:: OPTIZE THIS TO USE ONLY ONE LOOP
  public static boolean increasingTriplet2(int[] nums) {
    return increasingTriplet2(nums, 0, 0, 0);
  }

  public static boolean increasingTriplet2(int[] nums, int f, int s, int t) {

    if (f > s || s > t) {
      return false;
    }

    if (f >= nums.length || s >= nums.length || t >= nums.length) {
      return false;
    }

    if (nums[f] < nums[s] && nums[s] < nums[t]) {
      return true;
    }

    boolean b = increasingTriplet2(nums, f, s + 1, t);

    boolean b1 = increasingTriplet2(nums, f, s, t + 1);

    boolean b2 = increasingTriplet2(nums, f + 1, s, t);

    return b || b1 || b2;
  }
}
