package org.leetcode.SlidingWindow;

public class LongestSubarrayOfAfterDeletingOneElement {

  /*
  Given a binary array nums, you should delete one element from it.

  Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

  Example 1:
  Input: nums = [1,1,0,1]
  Output: 3
  Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

  Example 2:
  Input: nums = [0,1,1,1,0,1,1,0,1]
  Output: 5
  Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

  Example 3:
  Input: nums = [1,1,1]
  Output: 2
  Explanation: You must delete one element.
  * */

  public static void main(String[] args) {
    int[] nums = {1, 1, 0, 1};
    System.out.println(longestSubarray(nums));
    int[] nums2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};
    System.out.println(longestSubarray(nums2));
    int[] nums3 = {1,1,1};
    System.out.println(longestSubarray(nums3));
  }

  public static int longestSubarray(int[] nums) {
    int i = 0, j = 0, total = 0, answer = 0, removedZero = 0;
    boolean detectedZeroes = false;

    while (i < nums.length) {

      while (removedZero < 2 && j < nums.length) {
        if (nums[j] == 0) {
          detectedZeroes = true;
          removedZero++;
        }
        else total++;
        j++;
      }

      answer = Math.max(answer, total);

      if (nums[i] == 0) removedZero--;
      else total--;

      i++;
    }

    if(answer == 0) return answer;
    return detectedZeroes ? answer : answer -1;
  }

}
