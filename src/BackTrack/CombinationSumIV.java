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

    List<List<Integer>> lists;

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        lists = new ArrayList<>();
        backtrack(nums, target, new ArrayList<>(), 0);
        return lists.size();
    }

    private void backtrack(int[] nums, int remain, ArrayList<Integer> tmpList, int start) {
        if (remain == 0) lists.add(new ArrayList<>(tmpList));
        else if (remain < 0) return;
        else {
            for (int i = start; i < nums.length; i++) {
                tmpList.add(nums[i]);
                backtrack(nums, remain - nums[i], tmpList, i);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

}
