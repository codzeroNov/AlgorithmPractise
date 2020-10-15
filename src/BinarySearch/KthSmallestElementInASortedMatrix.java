package BinarySearch;

public class KthSmallestElementInASortedMatrix {
    /*
    Given a n x n matrix where each of the rows and columns are sorted in ascending order,
    find the kth smallest element in the matrix.

    Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     */

    //时间复杂度：O(n\log(r-l))O(nlog(r−l))，二分查找进行次数为 O(\log(r-l))O(log(r−l))，每次操作时间复杂度为 O(n)O(n)。
    //空间复杂度：O(1)O(1)。
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1, j = 0, count = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return count >= k;
    }
}
