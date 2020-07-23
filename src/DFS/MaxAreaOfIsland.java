package DFS;

public class MaxAreaOfIsland {


    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    max = Math.max(max, getArea(grid, i, j));

        return max;
    }

    private int getArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
        return 1 + getArea(grid, i - 1, j) + getArea(grid, i + 1, j) + getArea(grid, i, j - 1) + getArea(grid, i, j + 1);
    }

}
