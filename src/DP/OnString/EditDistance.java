package DP.OnString;

import java.util.Arrays;

public class EditDistance {
    /*
        Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

        You have the following 3 operations permitted on a word:
        Insert a character
        Delete a character
        Replace a character
    */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        return dp[m][n];
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] pre = new int[n + 1], cur = new int[n + 1];

        for (int j = 1; j <= n; j++)
            pre[j] = j;

        for (int i = 1; i <= m; i++) {
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cur[j] = pre[j - 1];
                else
                    cur[j] = 1 + Math.min(pre[j - 1], Math.min(pre[j], cur[j - 1]));
            }
            int[] tmp = pre;
            pre = cur;
            cur = tmp;
            Arrays.fill(cur, 0);
        }

        return pre[n];
    }

    public int minDistance3(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] cur = new int[n + 1];

        for (int j = 1; j <= n; j++)
            cur[j] = j;

        for (int i = 1; i <= m; i++) {
            int pre = cur[0];
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                int tmp = cur[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cur[j] = pre;
                else
                    cur[j] = 1 + Math.min(pre, Math.min(cur[j], cur[j - 1]));

                pre = tmp;
            }
        }

        return cur[n];
    }
}
