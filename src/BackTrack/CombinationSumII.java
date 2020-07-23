package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    //组合总和 每个元素只能使用一次 解集不重

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return ret;
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), target, 0);
        return ret;
    }

    private void backtrack(int[] candidates, ArrayList<Integer> tmpList, int target, int start) {
        if (target < 0) return;
        else if (target == 0) ret.add(new ArrayList<>(tmpList));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) continue;// i > start is the key to skip duplicates
                tmpList.add(candidates[i]);
                backtrack(candidates, tmpList, target - candidates[i], i + 1); // ditto
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }



}
