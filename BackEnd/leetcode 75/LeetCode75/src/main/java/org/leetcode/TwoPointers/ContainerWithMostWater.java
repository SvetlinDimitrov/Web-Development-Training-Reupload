package org.leetcode.TwoPointers;

public class ContainerWithMostWater {
  //TODO:: FINISH THIS


  /*
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
    In this case, the max area of water (blue section) the container can contain is 49.
  */

  public static void main(String[] args) {
//    int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//    System.out.println(maxArea(nums));
//    int[] nums2 = new int[]{1, 1};
//    System.out.println(maxArea(nums2));
    int[] nums3 = new int[]{1, 2, 1};
    System.out.println(maxArea(nums3));
  }

  public static int maxArea(int[] height) {
    int maxHeight = 0;

    int i = 0;
    int i2 = i;
    while (height.length > i) {

      if (height[i2] < height[i]) i2 = i;
      else maxHeight = Math.max(Math.min(height[i], height[i2]) * (i - i2), maxHeight);

      i++;
    }

    return maxHeight;
  }
}
