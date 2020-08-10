package DP.DecisionMaking;

public class HouseRobberII {
    /*
        You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
        All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
        Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
        Given a list of non-negative integers representing the amount of money of each house,
        determine the maximum amount of money you can rob tonight without alerting the police.
    */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int left, int right) {
        int preMax = 0, curMax = 0;
        for (int i = left; i < right; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }
        return curMax;
    }
}
