package BinarySearch;

public class FindPeakElementII {
    /**
     * A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
     *
     * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
     *
     * You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
     *
     * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
     * **/

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length, l = 0, r = n - 1;

        while (l <= r) {
            int mid = (r - l)/2 + l, maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid])
                    maxRow = i;
            }

            if ((mid == 0 || mat[maxRow][mid] > mat[maxRow][mid - 1]) && (mid == n - 1 || mat[maxRow][mid] > mat[maxRow][mid+1]))
                return new int[]{maxRow, mid};
            else if (mid > 0 && mat[maxRow][mid - 1] > mat[maxRow][mid])
                r = mid - 1;
            else
                l = mid + 1;
        }

        return new int[]{-1, -1};
    }
}
