package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    //无重复元素 组合总和

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return ret;


        backtrack(candidates, new ArrayList<>(), target, 0);
        return ret;
    }

    private void backtrack(int[] candidates, ArrayList<Integer> tmpList, int target, int start) {
        if (target < 0) return;
        else if (target == 0) ret.add(new ArrayList<>(tmpList));
        else
            for (int i = start; i < candidates.length; i++) {
                tmpList.add(candidates[i]);
                backtrack(candidates, tmpList, target - candidates[i], i);
                tmpList.remove(tmpList.size()-1);
            }
    }

}
