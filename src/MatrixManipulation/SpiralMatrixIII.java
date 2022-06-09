package MatrixManipulation;

public class SpiralMatrixIII {
    /*
    * You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

    You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

    Return an array of coordinates representing the positions of the grid in the order you visited them.
    * */

    public int[][] spiralMatrixIII(int rows, int cols, int x, int y) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, len = 1, size = 1;
        int[][] res = new int[rows * cols][2];
        res[0][0] = x;
        res[0][1] = y;

        while (size < res.length) {
            for (int i = 1; i <= len; i++) {
                x += dirs[d][0];
                y += dirs[d][1];
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    res[size][0] = x;
                    res[size][1] = y;
                    size++;
                }
            }
            d = (d + 1) % 4;
            if (d == 0 || d == 2)
                len++;
        }

        return res;
    }
}
