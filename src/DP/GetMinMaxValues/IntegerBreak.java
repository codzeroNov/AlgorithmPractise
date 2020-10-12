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
            int curMax = 0;
            for (int j = 1; j < i; j++)
                curMax = Math.max(curMax, Math.max((i - j) * j, j * dp[i - j]));
            dp[i] = curMax;
        }

        return dp[n];
    }
}
