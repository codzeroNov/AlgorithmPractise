package DP.DistinctWays;

public class NumberOfDiceRollsWithTargetSum {

    /*
        You have d dice, and each die has f faces numbered 1, 2, ..., f.

        Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.
    */
    public int numRollsToTarget(int d, int f, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= j && k <= f; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= MOD;
                }
            }
        }

        return dp[d][target];
    }

}
