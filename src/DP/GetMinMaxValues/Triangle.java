package DP.GetMinMaxValues;

import java.util.List;

public class Triangle {

/*
    Given a triangle, find the minimum path sum from top to bottom.
    Each step you may move to adjacent numbers on the row below.

    For example, given the following triangle
        [
        [2],
        [3,4],
        [6,5,7],
        [4,1,8,3]
        ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Note:
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*/



    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();

        int[][] dp = new int[rows][cols];

        for (int j = 0; j < cols; j++) {
            dp[rows-1][j] = triangle.get(rows-1).get(j);
        }

        for (int i = rows-2, m = 0; i >= 0; i--, m++) {
            for (int j = 0; j <= cols - 2 - m; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();

        int[] dp = new int[cols];

        for (int j = 0; j < cols; j++) {
            dp[j] = triangle.get(rows-1).get(j);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j <= rows; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

}
