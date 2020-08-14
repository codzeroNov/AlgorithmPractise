package OtherTricky;

public class SearchA2DMatrixII {
    /*
        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted in ascending from left to right.
        Integers in each column are sorted in ascending from top to bottom.
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i< m && j >= 0) {
            if (matrix[i][j] == target)
                return true;

            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }

        return false;
    }

}
