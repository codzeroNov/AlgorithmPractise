package DFS;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    /**
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.
     *
     * Count the number of distinct islands. An island is considered to be the same as another if and only if one island has the same shape as another island (and not rotated or reflected).
     * **/

    int n , m;
    boolean[][] visited;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numberOfDistinctIslands(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Set<String> set = new HashSet<>();
        visited = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    String coordinate = "";
                    dfs(i, j, grid, coordinate, i, j);
                    set.add(coordinate);
                }
            }
        }
        return set.size();
    }

    public void dfs(int x, int y, int grid[][], String coordinate, int originalX, int originalY) {
        visited[x][y] = true;
        coordinate += (x - originalX) + "" + (y - originalY);
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || grid[nx][ny] == 0)
                continue;
            dfs(nx, ny, grid, coordinate, originalX, originalY);
        }
    }
}
