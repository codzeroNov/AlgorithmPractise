package DP.DistinctWays;

public class DominoAndTrominoTiling {

/*
    We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.

    XX  <- domino
    XX  <- "L" tromino
    X

    Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.
    (In a tiling, every square must be covered by a tile.
    Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)

    Example:
    Input: 3
    Output: 5
    Explanation:
    The five different ways are listed below, different letters indicates different tiles:
    XYZ XXZ XYY XXY XYY
    XYZ YYZ XZZ XYY XXY

    Note:
    N will be in range [1, 1000].
*/


    public int numTilings(int N) {
        int MOD = 1000000007;
        long[] f = new long[1001];
        f[1] = 1l;
        f[2] = 2l;
        f[3] = 5l;
        if (N <= 3) return (int)f[N];
        for (int i = 4; i <= N; i++) {
            f[i] = 2 * f[i - 1] + f[i - 3];
            f[i] %= MOD;
        }

        return (int)f[N];
    }
}
