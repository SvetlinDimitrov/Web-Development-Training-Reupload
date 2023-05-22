import java.util.HashMap;
import java.util.Map;

public class Anser {
    /*
    Find all substrings of a string that are a permutation of another string

    Find all substrings of a string that contains all characters of another string.
    In other words, find all substrings of the first string that are anagrams of the second string.

    Please note that the problem specifically targets substrings that are contiguous
    (i.e., occupy consecutive positions) and inherently maintains the order of elements.

    For example,

    The first string is 'XYYZXZYZXXYZ'
    The second string is 'XYZ'

    Anagram 'YZX' present at index 2
    Anagram 'XZY' present at index 4
    Anagram 'YZX' present at index 6
    Anagram 'XYZ' present at index 9
     */
    public static void main(String[] args) {
        String word1 = "XYYZXZYZXXYZ";
        String word2 = "XYZ";

        findPermoWord2(word1, word2);
    }

    private static void findPermoWord2(String word1, String word2) {
        Map<Character, Integer> mapToCheck = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            mapToCheck.put(word2.charAt(i), mapToCheck.getOrDefault(word2.charAt(i), 0) + 1);
        }
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < word1.length()) {
            map.put(word1.charAt(end), map.getOrDefault(word1.charAt(end), 0) + 1);
            end++;
            if(end - start == word2.length()){
                if (map.equals(mapToCheck)) {
                    System.out.println(word1.substring(start, end));
                }
                map.put(word1.charAt(start), map.get(word1.charAt(start)) - 1);
                if (map.get(word1.charAt(start)) == 0) {
                    map.remove(word1.charAt(start));
                }
                start++;
            }
        }
    }
}
