package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

/*
    Find all possible combinations of k numbers that add up to a number n,
    given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

    Note:
    All numbers will be positive integers.
    The solution set must not contain duplicate combinations.

    Example 1:
    Input: k = 3, n = 7
    Output: [[1,2,4]]
    Example 2:

    Input: k = 3, n = 9
    Output: [[1,2,6], [1,3,5], [2,3,4]]
*/


    List<List<Integer>> ret;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ret = new ArrayList<>();
        backtrack(k, n, new ArrayList<Integer>(), 1);
        return ret;
    }

    private void backtrack(int k, int remain, ArrayList<Integer> tmpList, int start) {
        if (tmpList.size() == k && remain == 0)
            ret.add(new ArrayList<>(tmpList));
        else if (remain < 0) return;
        else {
            for (int num = start; num <= 9; num++) {
                tmpList.add(num);
                backtrack(k, remain-num, tmpList, num+1);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }

}
