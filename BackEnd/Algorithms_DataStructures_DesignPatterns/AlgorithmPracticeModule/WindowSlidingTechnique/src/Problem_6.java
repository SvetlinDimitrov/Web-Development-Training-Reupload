import java.util.*;

public class Problem_6 {
    /*
    Find the longest substring of a string containing `k` distinct characters

    Given a string and a positive number k, find the longest substring of the string containing k distinct characters.
    If k is more than the total number of distinct characters in the string, return the whole string.

    The problem differs from the problem of finding the longest subsequence with k distinct characters.
    Unlike subsequences, substrings are required to occupy consecutive positions within the original string.


    For example, consider string abcbdbdbbdcdabd.
    For k = 2, o/p is ‘bdbdbbd’
    For k = 3, o/p is ‘bcbdbdbbdcd’
    For k = 5, o/p is ‘abcbdbdbbdcdabd’
     */
    public static void main(String[] args) {
        String word = "abcbdbdbbdcdabd";
        int k = 2;
        System.out.println(findLongestSubstring(word, k));
    }

    public static String findLongestSubstring(String str, int k) {
        // base case
        if (str == null || str.length() == 0) {
            return str;
        }

        // stores the longest substring boundaries
        int end = 0, begin = 0;

        // set to store distinct characters in a window
        Set<Character> window = new HashSet<>();

        // Count array `freq` stores the frequency of characters present in the
        // current window. We can also use a map instead of a count array.
        int[] freq = new int[128];

        // `[low…high]` maintains the sliding window boundaries
        for (int low = 0, high = 0; high < str.length(); high++) {
            window.add(str.charAt(high));
            freq[str.charAt(high)]++;

            // if the window size is more than `k`, remove characters from the left
            while (window.size() > k) {
                // If the leftmost character's frequency becomes 0 after
                // removing it in the window, remove it from the set as well
                if (--freq[str.charAt(low)] == 0) {
                    window.remove(str.charAt(low));
                }

                low++;        // reduce window size
            }

            // update the maximum window size if necessary
            if (end - begin < high - low) {
                end = high;
                begin = low;
            }
        }

        // return the longest substring found at `str[begin…end]`
        return str.substring(begin, end + 1);
    }

}
