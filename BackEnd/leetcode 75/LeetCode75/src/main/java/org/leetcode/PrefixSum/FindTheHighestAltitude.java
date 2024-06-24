package org.leetcode.PrefixSum;

public class FindTheHighestAltitude {

  /*
  There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

  You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n).
   Return the highest altitude of a point.

  Example 1:
  Input: gain = [-5,1,5,0,-7]
  Output: 1
  Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.

  Example 2:
  Input: gain = [-4,-3,-2,-1,4,3,2]
  Output: 0
  Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
  * */


  public static void main(String[] args) {
    int[] nums = {-5, 1, 5, 0, -7};
    System.out.println(largestAltitude(nums));
    int[] nums2 = {-4, -3, -2, -1, 4, 3, 2};
    System.out.println(largestAltitude(nums2));
  }

  public static int largestAltitude(int[] gain) {

    int i = 1, max = Math.max(gain[0], 0);
    while (i < gain.length) {
      gain[i] = gain[i - 1] + gain[i];
      max = Math.max(max, gain[i]);
      i++;
    }

    return max;
  }
}
