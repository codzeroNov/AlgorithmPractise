package DP.GetMinMaxValues;

public class OnesAndZeroes {
/*
    Given an array, strs, with strings consisting of only 0s and 1s. Also two integers m and n.
    Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
    Each 0 and 1 can be used at most once.

    Example 1:
    Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
    Output: 4
    Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10","0001","1","0".

    Example 2:
    Input: strs = ["10","0","1"], m = 1, n = 1
    Output: 2
    Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

    Constraints:
    1 <= strs.length <= 600
    1 <= strs[i].length <= 100
    strs[i] consists only of digits '0' and '1'.
    1 <= m, n <= 100
*/

    public int findMaxForm(String[] strs, int m, int n) {
        /*
        For dp[i][j][k], we can get it by fetching the current string i or discarding the current string,
        which would result in
        dp[i][j][k] = dp[i-1][j-numOfZero(strs[i])][k-numOfOnes(strs[i])]
        and
        dp[i][j][k] = dp[i-1][j][k];
        We only need to treat the larger one in it as the largest number for dp[i][j][k].
        */
        int len = strs.length;

        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 0; i <= len; i++) {

            int[] num = new int[2];
            if (i > 0)
                num = calculate(strs[i - 1]);

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 0;
                    } else if (j >= num[0] && k >= num[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - num[0]][k - num[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];

        for (String str : strs) {
            int[] num = new int[2];
            num = calculate(str);
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i >= num[0] && j >= num[1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-num[0]][j-num[1]] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }

    private int[] calculate(String str) {
        int[] num = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0')
                num[0]++;
            else if (c == '1')
                num[1]++;
        }

        return num;
    }

}
