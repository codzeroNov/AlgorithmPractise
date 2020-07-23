package DP.GetMinMaxValues;

public class TwoKeysKeyboard {
/*
    Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

    Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
    Paste: You can paste the characters which are copied last time.


    Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted.
    Output the minimum number of steps to get n 'A'.
*/

    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i / 2; j > 1; j--) {
                // if sequence of length 'j' can be pasted multiple times to get length 'i' sequence
                if (i % j == 0) {
                    // we just need to paste sequence j (i/j - 1) times, hence additional (i/j) times since we need to copy it first as well.
                    // we don't need checking any smaller length sequences
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }

        return dp[n];
    }

}
