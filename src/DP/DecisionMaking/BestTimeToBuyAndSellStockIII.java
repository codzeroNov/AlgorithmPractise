package DP.DecisionMaking;

public class BestTimeToBuyAndSellStockIII {
    /*
        Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete at most two transactions.

        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
    */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][][] dp = new int[prices.length][3][2];
        dp[0][2][1] = -prices[0];
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }

        return dp[prices.length - 1][2][0];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int release1, release2, hold2, hold1;
        hold1 = hold2 = -prices[0];
        release1 = release2 = 0;

        for (int i = 1; i < prices.length; i++) {
            release2 = Math.max(release2, hold2 + prices[i]);
            hold2 = Math.max(hold2, release1 - prices[i]);
            release1 = Math.max(release1, hold1 + prices[i]);
            hold1 = Math.max(hold1, -prices[i]);
        }

        return release2;
    }

}
