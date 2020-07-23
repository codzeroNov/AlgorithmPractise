package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
/*
    Given a set of distinct integers, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:
    Input: nums = [1,2,3]
    Output:
            [
            [3],
            [1],
            [2],
            [1,2,3],
            [1,3],
            [2,3],
            [1,2],
            []
            ]
*/

    List<List<Integer>> ret;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return ret;

        ret = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);

        return ret;
    }

    private void backtrack(int[] nums, ArrayList<Integer> tmpList, int start) {
        ret.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backtrack(nums, tmpList, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

}
