package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIV {
/*
    Given an integer array with all positive numbers and no duplicates,
    find the number of possible combinations that add up to a positive integer target.

    Example:
    nums = [1, 2, 3]
    target = 4

    The possible combination ways are:
            (1, 1, 1, 1)
            (1, 1, 2)
            (1, 2, 1)
            (1, 3)
            (2, 1, 1)
            (2, 2)
            (3, 1)

    Note that different sequences are counted as different combinations.

    Therefore the output is 7.

    Follow up:
    What if negative numbers are allowed in the given array?
    How does it change the problem?
    What limitation we need to add to the question to allow negative numbers?
*/
    // there is a bug in this question's description: it should be combination, not permutation.
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), 0, nums, target);

        return res.size();
    }

    private void backTrack(List<List<Integer>> res, List<Integer> sub, int start, int[] nums, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            backTrack(res, sub, i, nums, target - nums[i]);
            sub.remove(sub.size()-1);
        }
    }
}
