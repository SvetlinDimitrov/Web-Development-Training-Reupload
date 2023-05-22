import java.util.Scanner;

public class Longest_Common_Subsequence {
    static String word1;
    static String word2;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        word1 = scanner.nextLine();
        word2 = scanner.nextLine();
        memo = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(memoSolve(0, 0));
    }

    private static int memoSolve(int p1, int p2) {
        // Check whether or not we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length
        // or p2 == text2.length.
        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        // Recursive cases.
        int answer = 0;
        if (word1.charAt(p1) == word2.charAt(p2)) {
            answer = 1 + memoSolve(p1 + 1, p2 + 1);
        } else {
            answer = Math.max(memoSolve(p1, p2 + 1), memoSolve(p1 + 1, p2));
        }

        // Add the best answer to the memo before returning it.
        memo[p1][p2] = answer;
        return memo[p1][p2];
    }
}

