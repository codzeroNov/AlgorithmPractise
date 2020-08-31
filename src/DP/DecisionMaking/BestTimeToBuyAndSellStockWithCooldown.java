package DP.DecisionMaking;

public class BestTimeToBuyAndSellStockWithCooldown {
    /*
        Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

        You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
        After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
    */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int cur0 = 0, cur1 = -prices[0], pre0 = 0;
        for (int i = 1; i < prices.length; i++) {
            int nxt0 = Math.max(cur0, cur1 + prices[i]);
            int nxt1 = Math.max(cur1, pre0 - prices[i]);
            pre0 = cur0;
            cur0 = nxt0;
            cur1 = nxt1;
        }

        return cur0;
    }
}
