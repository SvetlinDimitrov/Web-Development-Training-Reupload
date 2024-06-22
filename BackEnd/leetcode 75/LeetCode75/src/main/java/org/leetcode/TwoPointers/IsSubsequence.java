package org.leetcode.TwoPointers;

public class IsSubsequence {

  /*
  Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

  A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

  Example 1:
  Input: s = "abc", t = "ahbgdc"
  Output: true

  Example 2:
  Input: s = "axc", t = "ahbgdc"
  Output: false
  */

  public static void main(String[] args) {
    String s = "abc", t = "ahbgdc";
    System.out.println(isSubsequence(s, t));
    String s1 = "axc", t1 = "ahbgdc";
    System.out.println(isSubsequence(s1, t1));
    String s2 = "aaaaaa", t2 = "bbaaaa";
    System.out.println(isSubsequence(s2, t2));
  }

//  public static boolean isSubsequence(String s, String t) {
//
//    int i = 0, j = 0;
//
//    while (i < s.length()) {
//
//      while (j < t.length() && s.charAt(i) != t.charAt(j)) {
//        j++;
//      }
//
//      if (j < t.length() && s.charAt(i) == t.charAt(j)) {
//        i++;
//        j++;
//      } else break;
//    }
//
//    return i == s.length();
//  }

  public static boolean isSubsequence(String s, String t) {

    int i = 0, j = 0;

    while (i < s.length() && j < t.length()) {
      if (t.charAt(j) == s.charAt(i)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }
}
