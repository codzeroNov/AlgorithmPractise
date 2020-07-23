package DP.DistinctWays;

public class PartitionEqualSubsetSum {
    //Given a non-empty array containing only positive integers,
    // find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        int sum = 0;
        for (int n : nums) sum += n;

        if ((sum & 1) == 1) return false;
        //dp[i][j] means pick 0...i nums that add up to j
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
            for (int j = 1; j <= sum / 2; j++) {
                if (dp[i - 1][j] || (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]))
                    dp[i][j] = true;
            }
        }

        return dp[nums.length][sum / 2];
    }

    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        int sum = 0;
        for (int n : nums) sum += n;
        if ((sum & 1) == 1) return false;

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum / 2; j > 0; j--) {
                if (dp[j] || (j >= nums[i - 1] && dp[j - nums[i - 1]]))
                    dp[j] = true;
            }
        }

        return dp[sum / 2];
    }
}
