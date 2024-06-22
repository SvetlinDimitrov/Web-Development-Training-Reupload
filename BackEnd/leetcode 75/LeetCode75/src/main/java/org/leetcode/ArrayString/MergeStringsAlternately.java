package org.leetcode.ArrayString;

public class MergeStringsAlternately {
  /*
  You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
  If a string is longer than the other, append the additional letters onto the end of the merged string.

  Return the merged string.

    Input: word1 = "abc", word2 = "pqr"
    Output: "apbqcr"
    Explanation: The merged string will be merged as so:
    word1:  a   b   c
    word2:    p   q   r
    merged: a p b q c r
  * */
  public static void main(String[] args) {
    String word1 = "abc", word2 = "pqr";
    System.out.println(mergeAlternately(word1, word2));
  }

  public static String mergeAlternately(String word1, String word2) {
    boolean firstWord = false , secondWord = false;
    int i = 0;
    StringBuilder answer = new StringBuilder();

    while (!firstWord && !secondWord) {
      if (word1.length() > i) answer.append(word1.charAt(i));
      else firstWord = true;
      if (word2.length() > i) answer.append(word2.charAt(i));
      else secondWord = true;
      i++;
    }

    if(firstWord && word2.length() > i) answer.append(word2.substring(i));
    if(secondWord && word1.length() > i) answer.append(word1.substring(i));

    return answer.toString();
  }
}
