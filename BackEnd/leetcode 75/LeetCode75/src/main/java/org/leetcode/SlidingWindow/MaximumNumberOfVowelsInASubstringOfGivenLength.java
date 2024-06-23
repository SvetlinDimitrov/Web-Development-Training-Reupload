package org.leetcode.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

  /*
  Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

  Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

  Example 1:
  Input: s = "abciiidef", k = 3
  Output: 3
  Explanation: The substring "iii" contains 3 vowel letters.

  Example 2:
  Input: s = "aeiou", k = 2
  Output: 2
  Explanation: Any substring of length 2 contains 2 vowels.

  Example 3:
  Input: s = "leetcode", k = 3
  Output: 2
  Explanation: "lee", "eet" and "ode" contain 2 vowels.
  * */

  public static void main(String[] args) {
    System.out.println(maxVowels("abciiidef", 3));
    System.out.println(maxVowels("aeiou", 2));
    System.out.println(maxVowels("leetcode", 3));
  }

  public static int maxVowels(String s, int k) {
    Set<Character> letters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    int answer = Integer.MIN_VALUE, matches = 0, i = 0, i2 = 0;

    while (i <= s.length() - k) {

      while (i2 < i + k) {
        if (letters.contains(s.charAt(i2))) matches++;
        i2++;
      }
      answer = Math.max(answer, matches);
      if (letters.contains(s.charAt(i))) matches--;
      i++;
    }
    return answer;
  }
}
