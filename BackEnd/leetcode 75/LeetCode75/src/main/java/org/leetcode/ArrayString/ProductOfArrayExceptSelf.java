package org.leetcode.ArrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductOfArrayExceptSelf {
  /*
  Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

  The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

  You must write an algorithm that runs in O(n) time and without using the division operation.

  Example 1:
  Input: nums = [1,2,3,4]
  Output: [24,12,8,6]

  Example 2:
  Input: nums = [-1,1,0,-3,3]
  Output: [0,0,9,0,0]
  */
  public static void main(String[] args) {
    int[] nums = {-1, 1, 0, -3, 3};
//    int[] nums = {1,2,3,4};
//    [0,2,3,4] TODO:: SOLCE THIS
    System.out.println(Arrays.stream(productExceptSelf(nums))
        .boxed()
        .map(Object::toString)
        .collect(Collectors.joining(","))
    );
  }

  public static int[] productExceptSelf(int[] nums) {

    int[] answer = new int[nums.length];
    int j = 0 , maxSum = 0;
    List<Integer> zeroes = new ArrayList<>();

    while(j < nums.length){
      if(j == 0) maxSum = nums[j];
      else if(nums[j] != 0) maxSum *= nums[j];
      else zeroes.add(j);
      j++;
    }

    if(zeroes.size() > 1){
      return answer;
    }

    for (int i = 0; i < nums.length; i++) {
      if(zeroes.size() == 1){
        if(nums[i] == 0) answer[i] = maxSum;
        else nums[i] = 0;
      }
      else answer[i] = maxSum / nums[i];
    }

    return answer;
  }
}
