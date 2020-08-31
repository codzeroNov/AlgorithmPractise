package DP.DecisionMaking;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    /*
        Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

        You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

        Return the maximum profit you can make.
    */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }

        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;

        int pre0 = 0, pre1 = -prices[0] - fee, cur0, cur1;
        for (int i = 1; i < prices.length; i++) {
            cur0 = Math.max(pre0, pre1 + prices[i]);
            cur1 = Math.max(pre1, pre0 - prices[i] - fee);
            pre0 = cur0;
            pre1 = cur1;
        }

        return pre0;
    }

}
