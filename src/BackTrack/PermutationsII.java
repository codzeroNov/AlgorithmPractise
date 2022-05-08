package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
/*

    Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    Example:
    Input: [1,1,2]
    Output:
            [
            [1,1,2],
            [1,2,1],
            [2,1,1]
            ]
*/

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], ret, new ArrayList<>());

        return ret;
    }

    private void backtrack(int[] nums, boolean[] used, List<List<Integer>> ret, ArrayList<Integer> tmpList) {
        if (nums.length == tmpList.size()) {
            ret.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            used[i] = true;
            tmpList.add(nums[i]);
            backtrack(nums, used, ret, tmpList);
            used[i] = false;
            tmpList.remove(tmpList.size() - 1);
        }

    }
}
