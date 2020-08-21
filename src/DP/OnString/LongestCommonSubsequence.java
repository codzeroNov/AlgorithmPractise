package DP.OnString;

public class LongestCommonSubsequence {
    /*
        Given two strings text1 and text2, return the length of their longest common subsequence.

        A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters.
        (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

        If there is no common subsequence, return 0.
    */
    // top down with memorization
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length() + 1][text2.length() + 1];
        return helper(text1.toCharArray(), text2.toCharArray(), memo, text1.length(), text2.length());
    }

    private int helper(char[] s1, char[] s2, Integer[][] memo, int i, int j) {
        if (i <= 0 || j <= 0) return 0;
        if (memo[i][j] != null) return memo[i][j];
        if (s1[i - 1] == s2[j - 1])
            return 1 + helper(s1, s2, memo, i - 1, j - 1);
        else
            return memo[i][j] = Math.max(helper(s1, s2, memo, i - 1, j), helper(s1, s2, memo, i, j - 1));
    }

    // bottom up without space optimization
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[text1.length()][text2.length()];
    }

    // bottom up with space optimization
    public int longestCommonSubsequence3(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            int prevRowCol = 0;
            for (int j = 1; j <= text2.length(); j++) {
                int tmp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[j] = prevRowCol + 1;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                prevRowCol = tmp;
            }
        }

        return dp[text2.length()];
    }
}
