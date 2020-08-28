package DP.DecisionMaking;

public class BestTimeToBuyAndSellStockII {
    /*
        Say you have an array prices for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
    */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int cur0, cur1, pre0 = 0, pre1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cur0 = Math.max(pre0, pre1 + prices[i]);
            cur1 = Math.max(pre1, pre0 - prices[i]);
            pre0 = cur0;
            pre1 = cur1;
        }

        return pre0;
    }
}
