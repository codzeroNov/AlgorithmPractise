package DP.GetMinMaxValues;

public class LongestIncreasingSubsequence {
    /*
        Given an unsorted array of integers, find the length of longest increasing subsequence.
    */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];// dp[i] means the length of LIS before index i
        dp[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            int currMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && currMax < dp[j]) {
                    currMax = dp[j];
                }
            }
            dp[i] = currMax + 1;
            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }

    // greedy + binary search
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int l = 0, r = size;

            while (l != r) {
                int mid = (l + r) / 2;
                if (tails[mid] < num)
                    l = mid + 1;
                else
                    r = mid;
            }

            tails[l] = num;
            if (l == size)
                size++;
        }

        return size;
    }
}
