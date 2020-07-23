package DP.DistinctWays;

public class CombinationSumIV {
    //给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (i >= nums[j - 1])
                    dp[i] += dp[i - nums[j - 1]];
            }
        }

        return dp[target];
    }
}
