package DP.DistinctWays;

public class TargetSum {

    /*
        You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

        Find out how many ways to assign symbols to make sum of integers equal to target S.
    */
    public int findTargetSumWays(int[] nums, int S) {
        //                  sum(P) - sum(N) = target
        //sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
        //                       2 * sum(P) = target + sum(nums)
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < S || (sum + S) % 2 > 0 ? 0 : getSubSet(nums, (S + sum) >>> 1);
    }

    private int getSubSet(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= nums[i - 1] ? dp[i - 1][j - nums[i - 1]] : 0);
            }
        }

        return dp[nums.length][target];
    }

    private int getSubSet2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] + dp[j - nums[i - 1]];
            }
        }

        return dp[target];
    }
}
