package MatrixManipulation;

public class SetMatrixZeroes {
/*
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

    Example 1:
    Input:
            [
            [1,1,1],
            [1,0,1],
            [1,1,1]
            ]
    Output:
            [
            [1,0,1],
            [0,0,0],
            [1,0,1]
            ]

    Example 2:
    Input:
            [
            [0,1,2,0],
            [3,4,5,2],
            [1,3,1,5]
            ]
    Output:
            [
            [0,0,0,0],
            [0,4,5,0],
            [0,3,1,0]
            ]
    Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
*/

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int m = matrix.length, n = matrix[0].length;

        boolean colZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) colZero = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (colZero)
                matrix[i][0] = 0;
        }
    }

}
