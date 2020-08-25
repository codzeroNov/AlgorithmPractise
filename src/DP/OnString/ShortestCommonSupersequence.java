package DP.OnString;

public class ShortestCommonSupersequence {
    /*
        Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
        If multiple answers exist, you may return any of them.

        (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)
    */

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = m, j = n, idx = dp[m][n];
        char[] res = new char[idx];
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res[--idx] = str1.charAt(i - 1);
                i--;
                j--;
            } else  if (dp[i - 1][j] < dp[i][j - 1]) {
                res[--idx] = str1.charAt(i - 1);
                i--;
            } else {
                res[--idx] = str2.charAt(j - 1);
                j--;
            }
        }
        while (i > 0) {
            res[--idx] = str1.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            res[--idx] = str2.charAt(j - 1);
            j--;
        }

        return new String(res);
    }
}
