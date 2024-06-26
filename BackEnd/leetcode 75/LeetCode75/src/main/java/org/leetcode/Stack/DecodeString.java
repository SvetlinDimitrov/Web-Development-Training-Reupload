package org.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {

  //TODO:: FINISH THE TASK
  /*
  Given an encoded string, return its decoded string.

  The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
   Note that k is guaranteed to be a positive integer.

  You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
  Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

  The test cases are generated so that the length of the output will never exceed 105.

  Example 1:
  Input: s = "3[a]2[bc]"
  Output: "aaabcbc"

  Example 2:
  Input: s = "3[a2[c]]"
  Output: "accaccacc"

  Example 3:
  Input: s = "2[abc]3[cd]ef"
  Output: "abcabccdcdcdef"
  */

  public static void main(String[] args) {
    System.out.println(decodeString("3[a]2[bc]"));
    System.out.println(decodeString("3[a2[c]]"));
    System.out.println(decodeString("2[abc]3[cd]ef"));
    System.out.println(decodeString("100[leetcode]"));
  }

  public static String decodeString(String s) {
    Deque<Integer> multipleHolder = new ArrayDeque<>();
    Deque<Integer> indexOfTheOpeningBracket = new ArrayDeque<>();
    StringBuilder answer = new StringBuilder(s);
    StringBuilder number = new StringBuilder();

    int i = 0;
    while (i < answer.length()) {

      char letter = answer.charAt(i);
      if (Character.isDigit(letter)) {
        number.append(letter);
        if (i < answer.length() && !Character.isDigit(answer.charAt(i + 1))){
          multipleHolder.push(Integer.parseInt(number.toString()));
          number.delete(0 , number.length());
        }

      } else if (letter == '[') indexOfTheOpeningBracket.push(i);
      else if (letter == ']' && !indexOfTheOpeningBracket.isEmpty() && !multipleHolder.isEmpty()) {

        int lastOpeningBracket = indexOfTheOpeningBracket.poll();
        StringBuilder wordToAppend = new StringBuilder();
        int multiplayer = multipleHolder.poll();

        for (int j = 0; j < multiplayer; j++) {
          String word = answer.substring(lastOpeningBracket + 1, i);
          wordToAppend.append(word);
        }
        int multipleIndex = lastOpeningBracket - String.valueOf(multiplayer).length();
        answer.replace(multipleIndex, i + 1, wordToAppend.toString());
        i = multipleIndex;
      }
      i++;
    }
    return answer.toString();
  }

}
