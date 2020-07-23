package OtherTricky;

public class SpiralMatrixII {

    //给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        if (n == 0) return m;

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;

        int num = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {


            for (int j = colStart; j <= colEnd; j++)//right
                m[rowStart][j] = num++;
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++)//down
                m[i][colEnd] = num++;
            colEnd--;

            if (rowStart <= rowEnd)
                for (int j = colEnd; j >= colStart; j--)//left
                    m[rowEnd][j] = num++;
            rowEnd--;

            if (colStart <= colEnd)
                for (int i = rowEnd; i >= rowStart; i--)//up
                    m[i][colStart] = num++;
            colStart++;
        }

        return m;
    }

}
