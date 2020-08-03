package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /*
        Given a string s, partition s such that every substring of the partition is a palindrome.
        Return all possible palindrome partitioning of s.

        Example:
        Input:"aab"
        Output:
                [
                ["aa","b"],
                ["a","a","b"]
                ]
    */
    //pure backtracking
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;

        backtrack(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void backtrack(String s, int start, ArrayList<String> sub, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                sub.add(s.substring(start, i + 1));
                backtrack(s, i + 1, sub, res);
                sub.remove(sub.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }

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
        backtrack(res, new ArrayList<String>(), 0, s ,dp);
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
