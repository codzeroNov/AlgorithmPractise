package KSum;

import java.util.Arrays;

public class ThreeSumClosest {
/*
    Given an array nums of n integers and an integer target,
    find three integers in nums such that the sum is closest to target. Return the sum of the three integers.
    You may assume that each input would have exactly one solution.

    Example 1:
    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


    Constraints:
            3 <= nums.length <= 10^3
            -10^3 <= nums[i] <= 10^3
            -10^4 <= target <= 10^4
*/

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int cur = nums[i] + nums[l] + nums[r];
                if (cur < target)
                    l++;
                else
                    r--;
                if (Math.abs(target - res) > Math.abs(target - cur))
                    res = cur;
            }
        }
        return res;
    }
}
