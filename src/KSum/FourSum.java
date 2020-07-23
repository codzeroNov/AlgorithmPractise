package KSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

/*
    Given an array nums of n integers and an integer target, are there elements a, b, c,
    and d in nums such that a + b + c + d = target?
    Find all unique quadruplets in the array which gives the sum of target.

    Note:

    The solution set must not contain duplicate quadruplets.

    Example:

    Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

    A solution set is:
            [
            [-1,  0, 0, 1],
            [-2, -1, 1, 2],
            [-2,  0, 0, 2]
            ]
*/

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0, nums.length - 1);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int k, int l, int r) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (l >= r || l >= nums.length)
            return res;
        if (k == 2) {
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    //skip duplicates
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        } else {
            for (int i = l; i < nums.length - k + 1; i++) {
                List<List<Integer>> sub = kSum(nums, target - nums[i], k - 1, i + 1, r);
                if (sub != null && sub.size() != 0) {
                    for (List list : sub)
                        list.add(0, nums[i]);

                    res.addAll(sub);
                }

                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;//skip duplicates
            }
        }
        return res;
    }

}
