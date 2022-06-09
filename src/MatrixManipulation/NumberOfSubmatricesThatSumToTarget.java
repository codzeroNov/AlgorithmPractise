package MatrixManipulation;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget {
/*
    Given a matrix, and a target, return the number of non-empty submatrices that sum to target.

    A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

    Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different:
    for example, if x1 != x1'.

    Example 1:
    Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
    Output: 4
    Explanation: The four 1x1 submatrices that only contain 0.

    Example 2:
    Input: matrix = [[1,-1],[-1,1]], target = 0
    Output: 5
    Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.

    Note:
            1 <= matrix.length <= 300
            1 <= matrix[0].length <= 300
            -1000 <= matrix[i] <= 1000
            -10^8 <= target <= 10^8
    */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/803353/Java-Solution-with-Detailed-Explanation
        int count = 0, m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                matrix[i][j] += matrix[i][j - 1];

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                Map<Integer, Integer> prefix = new HashMap<>();
                prefix.put(0, 1);
                int sum = 0;
                for (int i = 0; i < m; i++) {
                    sum += matrix[i][end] - (end == start ? 0 : matrix[i][start]);
                    if (prefix.containsKey(sum - target))
                        count += prefix.get(sum - target);
                    prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}
