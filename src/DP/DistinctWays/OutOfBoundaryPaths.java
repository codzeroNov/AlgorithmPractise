package DP.DistinctWays;

public class OutOfBoundaryPaths {
    /*
        There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball,
        you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right).
        However, you can at most move N times.
        Find out the number of paths to move the ball out of grid boundary.
        The answer may be very large, return it after mod 10^9 + 7.
    */
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int[][][] count = new int[N][m][n];
        count[0][i][j] = 1;
        int res = 0, MOD = 1000000007;

        for (int step = 1; step < N; step++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir : dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            res = (res + count[step - 1][r][c]) % MOD;
                        } else {
                            count[step][nr][nc] = (count[step - 1][r][c] + count[step][nr][nc]) % MOD;
                        }
                    }
                }
            }
        }

        return res;
    }

    public int findPaths2(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] current = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        } else {
                            current[nr][nc] = (current[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = current;
        }

        return result;
    }
}
