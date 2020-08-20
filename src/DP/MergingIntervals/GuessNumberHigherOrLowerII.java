package DP.MergingIntervals;

public class GuessNumberHigherOrLowerII {
    /*
        We are playing the Guess Game. The game is as follows:

        I pick a number from 1 to n. You have to guess which number I picked.

        Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

        However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
    */

    // top down
    public int getMoneyAmount(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return helper(memo, 1, n);
    }

    private int helper(int[][] memo, int l, int r) {
        if (l >= r) return 0;
        if (memo[l][r] > 0) return memo[l][r];
        memo[l][r] = Integer.MAX_VALUE;
        for (int k = l; k < r; k++) {
            int tmp = k + Math.max(helper(memo, l, k - 1), helper(memo, k + 1, r)); // get max cuz we need to prepare enough money to find the target
            memo[l][r] = Math.min(tmp, memo[l][r]);
        }
        return memo[l][r];
    }

    // bottom up
    public int getMoneyAmount2(int n) {
        int[][] memo = new int[n + 1][n + 1];

        for (int interval = 1; interval <= n; interval++) {
            for (int l = 1; l + interval <= n; l++) {
                int r = l + interval;
                if (l + 1 == r) {
                    memo[l][r] = l;
                    continue;
                }
                memo[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    int tmp = k + Math.max(memo[l][k - 1], memo[k + 1][r]);
                    memo[l][r] = Math.min(memo[l][r], tmp);
                }
            }
        }

        return memo[1][n];
    }

    // another bottom up
    public int getMoneyAmount3(int n) {
        int[][] memo = new int[n + 1][n + 1];

        for (int r = 2; r <= n; r++) {
            for (int l = r - 1; l >= 0; l--) {
                if (l == r - 1) {
                    memo[l][r] = l;
                    continue;
                }
                memo[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    int tmp = k + Math.max(memo[l][k - 1], memo[k + 1][r]);
                    memo[l][r] = Math.min(memo[l][r], tmp);
                }
            }
        }
        return memo[1][n];

    }

}
