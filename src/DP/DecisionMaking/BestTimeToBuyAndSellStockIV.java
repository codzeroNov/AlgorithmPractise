package DP.DecisionMaking;

public class BestTimeToBuyAndSellStockIV {
    /*
        Say you have an array for which the i-th element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete at most k transactions.
    */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0)
            return 0;

        int n = prices.length;
        if (k >= n / 2) return maxProfit(prices);
        int[][][] dp = new int[prices.length][k + 1][2];

        for (int i = 1; i <= k; i++) dp[0][i][1] = - prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j > 0; j--) { // j travels in ascending order is ok
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][k][0];
    }

    private int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0)
            return 0;

        int n = prices.length;
        if (k >= n / 2) return maxProfit(prices);
        int[][] dp = new int[k + 1][2];

        for (int i = 1; i <= k; i++) dp[i][1] = - prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {// j must travel in descending order
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }

        return dp[k][0];
    }

}
