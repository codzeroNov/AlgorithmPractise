package DP.OnString;

import java.util.Arrays;

public class DistinctSubsequences {
    /*
        Given a string S and a string T, count the number of distinct subsequences of S which equals T.

        A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

        It's guaranteed the answer fits on a 32-bit signed integer.
    */
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[m][n];
    }

    public int numDistinct2(String s, String t) {
        int m = s.length(), n = t.length();
        int[] pre = new int[m + 1];
        int[] cur = new int[m + 1];

        for (int i = 0; i <= m; i++)
            pre[i] = 1;

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    cur[i] = cur[i - 1] + pre[i - 1];
                else
                    cur[i] = cur[i - 1];
            }
            int[] tmp = pre;
            pre = cur;
            cur = tmp;
            Arrays.fill(cur, 0);
        }

        return pre[m];
    }

    public int numDistinct3(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n];
    }
}
