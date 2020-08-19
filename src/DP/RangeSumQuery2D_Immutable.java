package DP;

public class RangeSumQuery2D_Immutable {
    /*
        Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
    */
    public class NumMatrix {
        /**
         * Your NumMatrix object will be instantiated and called as such:
         * NumMatrix obj = new NumMatrix(matrix);
         * int param_1 = obj.sumRegion(row1,col1,row2,col2);
         */

        private int[][] dp;
        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return;

            int m = matrix.length, n = matrix[0].length;
            dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int rMin = Math.min(row1, row2);
            int rMax = Math.max(row1, row2);

            int cMin = Math.min(col1, col2);
            int cMax = Math.max(col1, col2);

            return dp[rMax + 1][cMax + 1] - dp[rMin][cMax + 1] - dp[rMax + 1][cMin] + dp[rMin][cMin];
        }
    }

}
