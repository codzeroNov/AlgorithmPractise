package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
/*
    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:
    Input: [1,2,2]
    Output:
            [
            [2],
            [1],
            [1,2,2],
            [2,2],
            [1,2],
            []
            ]
*/

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return ret;
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);

        return ret;

    }

    private void backtrack(int[] nums, ArrayList<Integer> tmpList, int start) {
        ret.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            tmpList.add(nums[i]);
            backtrack(nums, tmpList, i);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
