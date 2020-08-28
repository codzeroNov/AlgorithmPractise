package DP.OnString;

import java.util.Arrays;

public class IsSubsequence {
    //Given a string s and a string t, check if s is subsequence of t.
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return true;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = dp[i][j - 1];

//                if (dp[i][j] == m)
//                    return true;
            }
        }

        return dp[m][n] == m;
    }

    public boolean isSubsequence2(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return true;
        int[] pre = new int[n + 1], cur = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    cur[j] = pre[j - 1] + 1;
                else
                    cur[j] = cur[j - 1];

//                if (cur[j] == m)
//                    return true;
            }
            int[] tmp = pre;
            pre = cur;
            cur = tmp;
            Arrays.fill(cur, 0);
        }

        return pre[n] == m;
    }

    public boolean isSubsequence3(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return true;
        int pre = 0, tmp = 0;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tmp = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[j] = pre + 1;
                else
                    dp[j] = dp[j - 1];

//                if (dp[j] == m)
//                    return true;

                pre = tmp;
            }
        }

        return dp[n] == m;
    }

    public boolean isSubsequence4(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }

        return i == n;
    }


}
