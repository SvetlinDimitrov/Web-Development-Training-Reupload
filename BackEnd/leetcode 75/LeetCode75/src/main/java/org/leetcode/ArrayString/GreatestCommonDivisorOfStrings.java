package org.leetcode.ArrayString;

public class GreatestCommonDivisorOfStrings {

  //TODO:: UNSOLVED
  /*
    For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

    Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

    Example 1:
    Input: str1 = "ABCABC", str2 = "ABC"
    Output: "ABC"

    Example 2:
    Input: str1 = "ABABAB", str2 = "ABAB"
    Output: "AB"

    Example 3:
    Input: str1 = "LEET", str2 = "CODE"
    Output: ""
  */

  public static void main(String[] args) {
//    String str1 = "ABABAB", str2 = "ABAB";
//    String str1 = "ABCABC", str2 = "ABC";
    String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX", str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
    System.out.println(gcdOfStrings(str1, str2));
  }

  public static String gcdOfStrings(String str1, String str2) {

    int i = 0;
    boolean b = false;
    while (str1.length() > i && !b) {
      if (str1.substring(i).contains(str2)) i += str2.length();
      else if (str2.contains(str1.substring(i))) i += Math.abs(str2.length() - str1.length());
      else b = true;
    }

    if (b) return "";

    int indexToStart = !str1.contains(str2) ? -1 : str1.indexOf(str2) + str2.length();
    return indexToStart == -1 ? "" : str1.substring(indexToStart);
  }

}
