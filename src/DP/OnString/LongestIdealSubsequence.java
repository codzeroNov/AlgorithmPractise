package DP.OnString;

import java.util.Arrays;

public class LongestIdealSubsequence {
    /**
     * You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:
     *
     * t is a subsequence of the string s.
     * The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
     * Return the length of the longest ideal string.
     *
     * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
     *
     * Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
     * **/
    // range searching
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            dp[pos] += 1;
            for (int j = Math.max(0, pos - k); j <= Math.min(25, pos + k); j++) {
                if (j != pos)
                    dp[pos] = Math.max(dp[pos], dp[j] + 1);
            }
            res = Math.max(res, dp[pos]);
        }
        return res;
    }
    // time limit exceed
    public int longestIdealString2(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(s.charAt(i) - s.charAt(j)) <= k)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
