package org.leetcode.HashMapSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetermineIfTwoStringsAreClose {

  /*
  *
  Two strings are considered close if you can attain one from the other using the following operations:

  Operation 1: Swap any two existing characters.
  For example, abcde -> aecdb
  Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
  For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
  You can use the operations on either string as many times as necessary.

  Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

  Example 1:
  Input: word1 = "abc", word2 = "bca"
  Output: true
  Explanation: You can attain word2 from word1 in 2 operations.
  Apply Operation 1: "abc" -> "acb"
  Apply Operation 1: "acb" -> "bca"

  Example 2:
  Input: word1 = "a", word2 = "aa"
  Output: false
  Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.

  Example 3:
  Input: word1 = "cabbba", word2 = "abbccc"
  Output: true
  Explanation: You can attain word2 from word1 in 3 operations.
  Apply Operation 1: "cabbba" -> "caabbb"
  Apply Operation 2: "caabbb" -> "baaccc"
  Apply Operation 2: "baaccc" -> "abbccc"
  *
  * */

  public static void main(String[] args) {

//    System.out.println(closeStrings("abc" , "bca"));
//    System.out.println(closeStrings("a" , "aa"));
//    System.out.println(closeStrings("cabbba" , "abbccc"));
    System.out.println(closeStrings("uau", "ssx"));
  }

  public static boolean closeStrings(String word1, String word2) {
    Map<Character, Integer> word1Map = new HashMap<>();
    Map<Character, Integer> word2Map = new HashMap<>();

    if (word1.length() != word2.length()) return false;

    for (int i = 0; i < word1.length(); i++) {
      char letterFromWord1 = word1.charAt(i);
      char letterFromWord2 = word2.charAt(i);

      word1Map.putIfAbsent(letterFromWord1, 0);
      word2Map.putIfAbsent(letterFromWord2, 0);

      word1Map.put(letterFromWord1, word1Map.get(letterFromWord1) + 1);
      word2Map.put(letterFromWord2, word2Map.get(letterFromWord2) + 1);
    }

    for (char letter : word1Map.keySet()) {
      if (word2Map.get(letter) == null) return false;
    }

    if (word1Map.size() != word2Map.size()) return false;

    List<Integer> list = word1Map.values().stream().sorted().toList();
    List<Integer> list2 = word2Map.values().stream().sorted().toList();

    for (int i = 0; i < list.size(); i++) {
      if (!list.get(i).equals(list2.get(i))) return false;
    }

    return true;

  }
}
