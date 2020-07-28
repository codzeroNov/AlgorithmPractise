package DP.DistinctWays;

public class DecodeWays {

/*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

            'A' -> 1
            'B' -> 2
            ...
            'Z' -> 26
    Given a non-empty string containing only digits, determine the total number of ways to decode it.
*/

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;

        // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if s[i] != '0'
        // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }

            int num = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        new DecodeWays().numDecodings("12");
    }
}
