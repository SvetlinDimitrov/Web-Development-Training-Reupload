package org.leetcode.ArrayString;

public class ReverseVowelsOfAString {

  /*
    Given a string s, reverse only all the vowels in the string and return it.

    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

    Example 1:
    Input: s = "hello"
    Output: "holle"

    Example 2:
    Input: s = "leetcode"
    Output: "leotcede"
  */

  public static void main(String[] args) {
    System.out.println(reverseVowels("hello"));
    System.out.println(reverseVowels("leetcode"));
  }

  public static String reverseVowels(String s) {
    String a = "aeiouAEIOU";
    char[] charArray = s.toCharArray();
    boolean [] toSwap = new boolean[charArray.length];
    int lastSwappedChar =charArray.length -1;

    for (int j = 0; j < charArray.length; j++) {
      if (j >= lastSwappedChar) break;
      else if (!toSwap[j] && a.indexOf(charArray[j]) != -1){
        for (int k = lastSwappedChar ; k >= 0; k--) {
          if(!toSwap[k] && a.indexOf(charArray[k]) != -1){
            char save = charArray[j];
            charArray[j] = charArray[k];
            charArray[k] = save;
            toSwap[j] = true;
            toSwap[k] = true;
            lastSwappedChar = k;
            break;
          }
        }
      }
    }

    return new String(charArray);
  }
}
