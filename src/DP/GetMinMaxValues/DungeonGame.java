package DP.GetMinMaxValues;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 0;

        int m = dungeon.length, n = dungeon[0].length;
        int[][] health = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    health[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else if (i == m - 1)
                    health[i][j] = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                else if (j == n - 1)
                    health[i][j] = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                else
                    health[i][j] = Math.max(Math.min(health[i + 1][j], health[i][j + 1]) - dungeon[i][j], 1);
            }
        }

        return health[0][0];
    }

}
