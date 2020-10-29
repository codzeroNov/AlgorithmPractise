package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    /*
    Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
    the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

    Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

    Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

    Note:
    The order of returned grid coordinates does not matter.
    Both m and n are less than 150.

    Example:
    Given the following 5x5 matrix:

      Pacific ~   ~   ~   ~   ~
           ~  1   2   2   3  (5) *
           ~  3   2   3  (4) (4) *
           ~  2   4  (5)  3   1  *
           ~ (6) (7)  1   4   5  *
           ~ (5)  1   1   2   4  *
              *   *   *   *   * Atlantic

    Return:
    [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
     */

    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m , n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        m = matrix.length;
        n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
        Queue<int[]> pacificQueue = new LinkedList<>(), atlanticQueue = new LinkedList<>();

        // put borders' position into queue
        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new int[]{0, j});
            atlanticQueue.offer(new int[]{m - 1, j});
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }

        bfs(matrix, pacificQueue, pacific);
        bfs(matrix, atlanticQueue, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlantic[i][j] && pacific[i][j]){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(i);
                    sub.add(j);
                    res.add(sub);
                }
            }
        }

        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]])
                    continue;
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        m = matrix.length;
        n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, j);
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(i);
                    sub.add(j);
                    res.add(sub);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || matrix[i][j] < height)
            return;
        visited[i][j] = true;
        for (int[] d : dirs) {
            dfs(matrix, visited, matrix[i][j], i + d[0], j + d[1]);
        }
    }

}
