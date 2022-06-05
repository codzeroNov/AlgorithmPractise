package DP.OnString;

public class PalindromicSubstrings {
    /*
        Given a string, your task is to count how many palindromic substrings in this string.

        The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
    */
    /**
     * same trick as below:
     {@link DP.OnString.LongestPalindromicSubstring}
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) { // to use dp[i+1][j-1], we need to make sure that i is in descending order and j is in ascending order
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }

}
