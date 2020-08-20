package DP.MergingIntervals;

public class MinimumScoreTriangulationOfPolygon {
    /*
        Given N, consider a convex N-sided polygon with vertices labelled A[0], A[i], ..., A[N-1] in clockwise order.

        Suppose you triangulate the polygon into N-2 triangles.
        For each triangle, the value of that triangle is the product of the labels of the vertices,
        and the total score of the triangulation is the sum of these values over all N-2 triangles in the triangulation.

        Return the smallest possible total score that you can achieve with some triangulation of the polygon.
    */
    public int minScoreTriangulation(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int n = A.length;
        int[][] dp = new int[n][n]; // dp[i][j] means the minimum value from point i to point j which forms a polygon
        for (int interval = 2; interval < n; interval++) { // the interval between i to j
            for (int i = 0; i + interval < n; i++) {
                int j = i + interval;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public int minScoreTriangulation2(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        for (int j = 2; j < n; j++) {
            for (int i = j - 2; i >= 0; i--) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
            }
        }

        return dp[0][n - 1];
    }

}
