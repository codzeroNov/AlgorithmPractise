package DP.DistinctWays;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    /*
        You have a pointer at index 0 in an array of size arrLen.
        At each step, you can move 1 position to the left, 1 position to the right in the array or stay in the same place (The pointer should not be placed outside the array at any time).

        Given two integers steps and arrLen, return the number of ways such that your pointer still at index 0 after exactly steps steps.

        Since the answer may be too large, return it modulo 10^9 + 7.
    */
    public int numWays(int steps, int arrLen) {
        if (arrLen == 1) return 1;

        long MOD = 1000000007;
        int len = Math.min(steps, arrLen);
        long[][] ways = new long[steps + 1][len + 1];

        ways[1][0] = 1;
        ways[1][1] = 1;

        for (int i = 2; i <= steps; i++) {
            for (int j = 0; j < len; j++) {
                ways[i][j] = ways[i - 1][j] + ways[i - 1][j + 1] + (j > 0 ? ways[i - 1][j - 1] : 0);
                ways[i][j] %= MOD;
            }
        }

        return (int) ways[steps][0];
    }

}
