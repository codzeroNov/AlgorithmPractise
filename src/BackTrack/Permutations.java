package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

/*
    Given a collection of distinct integers, return all possible permutations.

    Example:
    Input: [1,2,3]
    Output:
            [
            [1,2,3],
            [1,3,2],
            [2,1,3],
            [2,3,1],
            [3,1,2],
            [3,2,1]
            ]
*/

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        backtrack(ret, new ArrayList<>(), nums);

        return ret;
    }

    private void backtrack(List<List<Integer>> ret, ArrayList<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length) {
            ret.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmpList.contains(nums[i])) continue;
                tmpList.add(nums[i]);
                backtrack(ret, tmpList, nums);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }


}
