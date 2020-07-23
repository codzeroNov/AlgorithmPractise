package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

            [
            "((()))",
            "(()())",
            "(())()",
            "()(())",
            "()()()"
            ]
    */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(n, res, "", 0, 0);
        return res;
    }

    private void backTrack(int n, List<String> res, String s, int l, int r) {
        if (s.length() == 2*n)
            res.add(s);
        //l and r begin with 0, so we don't use <=
        if (l < n)
            backTrack(n, res, s+"(", l+1, r);
        if (r < l)
            backTrack(n, res, s+")", l, r+1);
    }

}
