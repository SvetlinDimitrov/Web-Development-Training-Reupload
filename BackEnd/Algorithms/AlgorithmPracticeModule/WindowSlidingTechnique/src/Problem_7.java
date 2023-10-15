import java.util.HashSet;
import java.util.Set;

public class Problem_7 {
    /*
    Find the longest substring of a string containing distinct characters

    Given a string, find the longest substring containing distinct characters.
    The problem differs from the problem of finding the longest subsequence with distinct characters.
    Unlike subsequences, substrings are required to occupy consecutive positions within the original string.

    For example,
    Input:  findlongestsubstring
    Output: The longest substring with all distinct characters is dlongest or ubstring

    Input:  longestsubstr
    Output: The longest substring with all distinct characters is longest

    Input:  abbcdafeegh
    Output: The longest substring with all distinct characters is bcdafe


    Input:  aaaaaa
    Output: The longest substring with all distinct characters is a
     */
    public static void main(String[] args) {
        System.out.println(distictWordLongest("aaaaaa"));
    }

    private static String distictWordLongest(String word) {
        String answer = "";
        Set<Character> setChar = new HashSet<>();

        for (int end = 0 , start =0; end < word.length(); end++) {
            char currentChar = word.charAt(end);
            if(setChar.contains(currentChar)){
                if(word.substring(start , end).length() > answer.length()){
                    answer = word.substring(start , end);
                }
                while(setChar.contains(currentChar)){
                    setChar.remove(word.charAt(start));
                    start++;
                }
            }
            setChar.add(currentChar);

        }
        return answer.length() == 0 ? word : answer;
    }
}
