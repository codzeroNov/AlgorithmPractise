package DP.GetMinMaxValues;

public class IntegerBreak {
    /*
    Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
    Return the maximum product you can get.
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
            dp[i] = max;
        }

        return dp[n];
    }
}
