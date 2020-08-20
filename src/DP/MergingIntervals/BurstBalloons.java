package DP.MergingIntervals;

public class BurstBalloons {
    /*
        Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
        You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
        Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

        Find the maximum coins you can collect by bursting the balloons wisely.

        Note:
        You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
        0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
    */
    // bottom up -- get every small interval result first then calculate the bigger one
    public int maxCoins(int[] nums) {
        int[] iNums = new int[nums.length + 2];

        int n = 1;
        for (int num : nums) if (num > 0) iNums[n++] = num; // skip all the balloons with value 0
        iNums[0] = iNums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int interval = 2; interval < n; interval++) {
            for (int i = 0; i + interval < n; i++) {
                int j = i + interval;
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + iNums[i] * iNums[k] * iNums[j]);
                }
            }
        }

        return dp[0][n - 1];
    }
    // another approach
    public int maxCoins2(int[] nums) {
        int[] iNums = new int[nums.length + 2];

        int n = 1;
        for (int num : nums) if (num > 0) iNums[n++] = num; // skip all the balloons with value 0
        iNums[0] = iNums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int j = 2; j < n; j++) {
            for (int i = j - 2; i >= 0; i--) {
                for (int k = i + 1; k < j; k++)
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + iNums[i] * iNums[k] * iNums[j]);
            }
        }

        return dp[0][n - 1];
    }

    // recursive with memorization(top down)
    public int maxCoins3(int[] nums) {
        int[] iNums = new int[nums.length + 2];

        int n = 1;
        for (int num : nums) if (num > 0) iNums[n++] = num; // skip all the balloons with value 0
        iNums[0] = iNums[n++] = 1;

        int[][] memo = new int[n][n];
        return burst(iNums, memo, 0, n - 1);
    }

    private int burst(int[] nums, int[][] memo, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        for (int k = left + 1; k < right; k++) {
            memo[left][right] = Math.max(memo[left][right], burst(nums, memo, left, k) + burst(nums, memo, k, right) + nums[left] * nums[k] * nums[right]);
        }
        return memo[left][right];
    }
}
