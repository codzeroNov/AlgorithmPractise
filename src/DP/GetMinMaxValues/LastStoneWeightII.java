package DP.GetMinMaxValues;

public class LastStoneWeightII {
/*
    We have a collection of rocks, each rock has a positive integer weight.

    Each turn, we choose any two rocks and smash them together.
    Suppose the stones have weights x and y with x <= y. The result of this smash is:

    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
    At the end, there is at most 1 stone left. Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
*/

    public int lastStoneWeightII(int[] stones) {
        /**
         This question eaquals to partition an array into 2 subsets whose difference is minimal
         (1) S1 + S2  = S
         (2) S1 - S2 = diff

         ==> -> diff = S - 2 * S2  ==> minimize diff equals to  maximize S2

         Now we should find the maximum of S2 , range from 0 to S / 2, using dp can solve this

         dp[i][j] means the max value of putting the first i number into a backpack with capacity of j

         same as 494. Target Sum
         */
        int n = stones.length;
        int s = 0;
        for (int stone : stones) s += stone;

        int[][] dp = new int[n + 1][s / 2 + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s / 2; j++) {
                if (j >= stones[i - 1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);//ith stone indexes i - 1
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return s - 2 * dp[n][s / 2];
    }

    public int lastStoneWeightII2(int[] stones) {
        int n = stones.length;
        int s = 0;
        for (int stone : stones) s += stone;

        int[] dp = new int[s / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = s / 2; j >= stones[i-1]; j--) {
                dp[j] = Math.max(dp[j-1], dp[j-stones[i-1]] + stones[i-1]);
            }
        }

        return s - 2 * dp[s/2];
    }

}
