package MatrixManipulation;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
/*
    给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

    示例 1:
    输入:
            [
            [ 1, 2, 3 ],
            [ 4, 5, 6 ],
            [ 7, 8, 9 ]
            ]
    输出: [1,2,3,6,9,8,7,4,5]

    示例 2:
    输入:
            [
            [1, 2, 3, 4],
            [5, 6, 7, 8],
            [9,10,11,12]
            ]
    输出: [1,2,3,4,8,12,11,10,9,5,6,7]

*/


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;

        while (left <= right && up <= down) {
            //right
            for (int j = left; j <= right; j++)
                res.add(matrix[up][j]);
            up++;
            //down
            for (int i = up; i <= down; i++)
                res.add(matrix[i][right]);
            right--;
            //left
            if (up <= down)
                for (int j = right; j >= left; j--)
                    res.add(matrix[down][j]);
            down--;
            //up
            if (left <= right)
                for (int i = down; i >= up; i--)
                    res.add(matrix[i][left]);
            left++;
        }

        return res;
    }


}
