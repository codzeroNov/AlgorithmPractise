package DP.DistinctWays;

public class MinCostClimbingStairs {
    /**
     * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
     *
     * You can either start from the step with index 0, or the step with index 1.
     *
     * Return the minimum cost to reach the top of the floor.
     * **/

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return Math.min(dp[cost.length - 2] + cost[cost.length - 2], dp[cost.length - 1] + cost[cost.length - 1]);
    }
}
