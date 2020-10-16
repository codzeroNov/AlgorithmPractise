package DFS;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    /*
    Given an integer n, return 1 - n in lexicographical order.

    For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

    Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
     */
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n);
        }
        return res;
    }

    private void dfs(int curr, int n) {
        if (curr > n) return;
        
        res.add(curr);
        for (int i = 0; i < 10; i++) {
            if (curr * 10 + i > n) return;
            dfs(curr * 10 + i, n);
        }
    }
}
