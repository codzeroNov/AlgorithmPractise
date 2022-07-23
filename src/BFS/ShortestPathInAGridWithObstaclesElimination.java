package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {
    /**
     * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.
     *
     * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
     * **/

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int res = 0;

        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] pos = q.poll();
                int x = pos[0], y = pos[1], currK = pos[2];

                if (x == m - 1 && y == n - 1)
                    return res;

                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1], nk = currK;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                        continue;
                    if (grid[nx][ny] == 1)
                        nk++;
                    if (nk <= k && !visited[nx][ny][nk]) {
                        q.offer(new int[]{nx, ny, nk});
                        visited[nx][ny][nk] = true;
                    }
                }
            }
            res++;
        }

        return -1;

    }
}
