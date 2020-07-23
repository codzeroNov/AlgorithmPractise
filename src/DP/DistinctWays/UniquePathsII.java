package DP.DistinctWays;


public class UniquePathsII {

    /*
        A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

        Now consider if some obstacles are added to the grids. How many unique paths would there be?
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                while (i < m)
                    paths[i++][0] = 0;
            else
                paths[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1)
                while (j < n)
                    paths[0][j++] = 0;
            else
                paths[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1)
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                else
                    paths[i][j] = 0;
            }
        }

        return paths[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] paths = new int[n];
        paths[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    paths[j] = 0;
                else if (j > 0)
                    paths[j] = paths[j] + paths[j - 1];
            }
        }

        return paths[n - 1];
    }
}
