package org.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class AsteroidCollision {

  /*
  We are given an array asteroids of integers representing asteroids in a row.

  For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
  Each asteroid moves at the same speed.

  Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
  If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

  Example 1:
  Input: asteroids = [5,10,-5]
  Output: [5,10]
  Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

  Example 2:
  Input: asteroids = [8,-8]
  Output: []
  Explanation: The 8 and -8 collide exploding each other.

  Example 3:
  Input: asteroids = [10,2,-5]
  Output: [10]
  Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
  * */


  public static void main(String[] args) {
    int[] nums1 = {5, 10, -5},
        nums2 = {8, -8},
        nums3 = {10, 2, -5},
        nums4 = {-2, -1, 1, 2},
        nums5 = {1, -2, -2, -2},
        nums6 = {-2, -2, 1, -2};
    System.out.println(formatArray(asteroidCollision(nums1)));
    System.out.println(formatArray(asteroidCollision(nums2)));
    System.out.println(formatArray(asteroidCollision(nums3)));
    System.out.println(formatArray(asteroidCollision(nums4)));
    System.out.println(formatArray(asteroidCollision(nums5)));
    System.out.println(formatArray(asteroidCollision(nums6)));
  }

  public static int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();

    for (int asteroid : asteroids) {
      if (stack.isEmpty()) stack.push(asteroid);
      else {
        boolean addTheSteroid = false;
        while (!stack.isEmpty()) {
          Integer prev = stack.poll();
          if (prev < 0) {
            stack.push(prev);
            stack.push(asteroid);
            break;
          } else {
            if (asteroid >= 0) {
              stack.push(prev);
              stack.push(asteroid);
              break;
            } else if (prev == Math.abs(asteroid)) {
              break;
            } else if (prev > Math.abs(asteroid)) {
              stack.push(prev);
              break;
            }
          }
          if (stack.isEmpty()) addTheSteroid = true;
        }
        if (addTheSteroid) stack.push(asteroid);
      }
    }

    int[] results = new int[stack.size()];
    int i = stack.size() - 1;
    while (!stack.isEmpty()) {
      results[i] = stack.poll();
      i--;
    }
    return results;
  }


  public static String formatArray(int[] nums) {
    return Arrays.stream(nums).boxed().map(Object::toString).collect(Collectors.joining(","));
  }
}
