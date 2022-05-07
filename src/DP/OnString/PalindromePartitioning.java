package DP.OnString;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    //backtracking + dp
    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int r = 0; r < s.length(); r++) {
            for (int l = 0; l <= r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1]))
                    dp[l][r] = true;
            }
        }
        backtrack(res, new ArrayList<>(), 0, s ,dp);
        return res;
    }

    private void backtrack(List<List<String>> res, ArrayList<String> sub, int start, String s, boolean[][] dp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                sub.add(s.substring(start, i + 1));
                backtrack(res, sub, i + 1, s, dp);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
