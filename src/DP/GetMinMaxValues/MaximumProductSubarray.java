package DP.GetMinMaxValues;

public class MaximumProductSubarray {

    //Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

    public int maxProduct(int[] nums) {
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        maxDP[0] = minDP[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxDP[i] = Math.max(Math.max(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]), nums[i]);
            minDP[i] = Math.min(Math.min(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]), nums[i]);

            res = Math.max(res, maxDP[i]);
        }

        return res;
    }

}
