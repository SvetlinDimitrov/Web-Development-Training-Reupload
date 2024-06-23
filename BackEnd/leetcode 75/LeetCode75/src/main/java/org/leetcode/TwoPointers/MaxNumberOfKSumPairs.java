package org.leetcode.TwoPointers;

public class MaxNumberOfKSumPairs {
  //TODO:: FINISH THIS
  /*
  You are given an integer array nums and an integer k.

  In one operation, you can pick two numbers from
  the array whose sum equals k and remove them from the array.

  Return the maximum number of operations you can perform on the array.

  Example 1:
  Input: nums = [1,2,3,4], k = 5
  Output: 2
  Explanation: Starting with nums = [1,2,3,4]:
  - Remove numbers 1 and 4, then nums = [2,3]
  - Remove numbers 2 and 3, then nums = []
  There are no more pairs that sum up to 5, hence a total of 2 operations.

  Example 2:
  Input: nums = [3,1,3,4,3], k = 6
  Output: 1
  Explanation: Starting with nums = [3,1,3,4,3]:
  - Remove the first two 3's, then nums = [1,4,3]
  There are no more pairs that sum up to 6, hence a total of 1 operation.
  * */

  public static void main(String[] args) {
    int[] nums = {3, 1, 3, 4, 3};
    int k = 6;
    System.out.println(maxOperations(nums, k));
    int[] nums2 = {1, 2, 3, 4};
    int k2 = 5;
    System.out.println(maxOperations(nums2, k2));
    int[] nums3 = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
    int k3 = 2;
    System.out.println(maxOperations(nums3, k3));
  }

  public static int maxOperations(int[] nums, int k) {

    int i = 0;
    int answer = 0;

    while (nums.length > i) {

      if (nums[i] != 0) {
        int i2 = i + 1;
        while (nums.length > i2) {
          if (nums[i2] != 0 && nums[i] + nums[i2] == k) {
            nums[i] = 0;
            nums[i2] = 0;
            answer++;
            break;
          } else i2++;
        }
      }

      i++;

    }
    return answer;
  }
}
