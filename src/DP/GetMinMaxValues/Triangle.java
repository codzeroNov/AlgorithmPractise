package DP.GetMinMaxValues;

import java.util.ArrayList;
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

    public int minimumTotal2(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<>());
        }

        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> sub = triangle.get(i);
            for (int j = 0; j < sub.size(); j++) {
                if (i == 0) {
                    dp.get(i).add(sub.get(j));

                } else if (j == 0) {
                    dp.get(i).add(sub.get(j) + dp.get(i - 1).get(j));
                } else if (j == sub.size() - 1) {
                    dp.get(i).add(sub.get(j) + dp.get(i - 1).get(j - 1));
                } else {
                    dp.get(i).add(Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + sub.get(j));
                }

            }
        }

        int res = dp.get(triangle.size() - 1).get(0);
        for (int j = 0; j < dp.get(triangle.size() - 1).size(); j++)
            res = Math.min(res, dp.get(triangle.size() - 1).get(j));

        return res;
    }

}
