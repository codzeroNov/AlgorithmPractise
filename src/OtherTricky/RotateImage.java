package OtherTricky;

public class RotateImage {
/*
    You are given an n x n 2D matrix representing an image.
    Rotate the image by 90 degrees (clockwise).
*/
    public void rotate(int[][] matrix) {
        //flip upside down
        int t = 0, b = matrix.length-1;
        while (t < b) {
            int[] tmp = matrix[t];
            matrix[t] = matrix[b];
            matrix[b] = tmp;
            t++;
            b--;
        }
        //flip diagonal
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }

}
