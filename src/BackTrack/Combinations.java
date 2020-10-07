package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    You may return the answer in any order.
    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> sub, int start, int n, int k) {
        if (sub.size() == k) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i <= n; i++) {
            sub.add(i);
            backtrack(res, sub, i + 1, n, k);
            sub.remove(sub.size() - 1);
        }
    }
}
