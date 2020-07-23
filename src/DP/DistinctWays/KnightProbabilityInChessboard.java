package DP.DistinctWays;

public class KnightProbabilityInChessboard {

    /*
        已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。 
        现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。 
        如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。

        现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
        求移动结束后，“马” 仍留在棋盘上的概率。
    */

    int[][] dirs = new int[][]{{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K + 1][N][N];
        dp[0][r][c] = 1;

        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir : dirs) {
                        int preRow = i + dir[0];
                        int preCol = j + dir[1];
                        if (preRow >= 0 && preCol >= 0 && preRow < N && preCol < N)
                            dp[k][i][j] += dp[k-1][preRow][preCol]/8.0;
                    }
                }
            }
        }

        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[K][i][j];
            }
        }

        return res;
    }

    public double knightProbability2(int N, int K, int r, int c) {
        double[][] pre = new double[N][N];
        pre[r][c] = 1;

        for (int k = 1; k <= K; k++) {
            double[][] dp = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir : dirs) {
                        int preRow = i + dir[0];
                        int preCol = j + dir[1];
                        if (preRow >= 0 && preCol >= 0 && preRow < N && preCol < N)
                            dp[i][j] += pre[preRow][preCol]/8.0;
                    }
                }
            }
            pre = dp;
        }

        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += pre[i][j];
            }
        }

        return res;
    }

}
