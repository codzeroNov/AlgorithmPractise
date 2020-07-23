package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    /*
        Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
        The distance between two adjacent cells is 1.

        Example 1:
        Input:
                [[0,0,0],
                [0,1,0],
                [0,0,0]]
        Output:
                [[0,0,0],
                [0,1,0],
                [0,0,0]]

        Example 2:
        Input:
                [[0,0,0],
                [0,1,0],
                [1,1,1]]
        Output:
                [[0,0,0],
                [0,1,0],
                [1,2,1]]

        Note:
        The number of elements of the given matrix will not exceed 10,000.
        There are at least one 0 in the given matrix.
        The cells are adjacent in only four directions: up, down, left and right.
    */
    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    q.offer(new int[]{i, j});
                else
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()) {
            int[] loc = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = loc[0] + dir[i][0];
                int c = loc[1] + dir[i][1];
                if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[loc[0]][loc[1]] + 1)
                    continue;
                matrix[r][c] = matrix[loc[0]][loc[1]] + 1;
                q.offer(new int[]{r, c});
            }
        }

        return matrix;
    }

    public int[][] updateMatrix2(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r = loc[0] + dir[i][0];
                int c = loc[1] + dir[i][1];
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c])
                    continue;
                visited[r][c] = true;
                matrix[r][c] = matrix[loc[0]][loc[1]] + 1;
                queue.offer(new int[]{r, c});
            }
        }
        return matrix;
    }
}
