package DP.OnString;

public class MinimumASCIIDeleteSumForTwoStrings {
    //Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // initiate the base condition
        for (int i = 1; i <= m; i++)
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        for (int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    // below line is redundant, if we look recursively
                    // dp[i - 1][j - 1] + s1.charAt(i - 1) + s2.charAt(j - 1) is a sub-problem we've already solved before
                    // in min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1))
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + s1.charAt(i - 1) + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }
}
