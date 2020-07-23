package DP.GetMinMaxValues;

public class MinCostClimbingStairs {
/*
    On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

    Once you pay the cost, you can either climb one or two steps.
    You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
*/

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + (i == cost.length ? 0 : cost[i]);
        }

        return dp[cost.length];
    }

}
