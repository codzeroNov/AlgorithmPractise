package OtherTricky;

public class SearchA2DMatrix {

/*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
*/


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //O(log(mn))
        if (matrix.length == 0 ||  matrix[0].length == 0 )
            return false;

        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
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
