package DP;

public class MaximumSubarray {
    //Given an integer array nums, find the contiguous subarray(containing at least one number) which has the largest sum and return its sum.

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0], pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i] + (pre > 0 ? pre : 0);
            max = Math.max(cur, max);
            pre = cur;
        }

        return max;
    }
}
