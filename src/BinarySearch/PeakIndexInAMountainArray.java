package BinarySearch;

public class PeakIndexInAMountainArray {
    /*
        Let's call an array A a mountain if the following properties hold:
        A.length >= 3
        There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
        Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
    */
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (A[mid] < A[mid + 1]) left = mid + 1;
            else if (A[mid - 1] > A[mid]) right = mid;
            else return mid;
        }

        return -1;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int left = 0, right = A.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (A[mid] > A[mid + 1]) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
