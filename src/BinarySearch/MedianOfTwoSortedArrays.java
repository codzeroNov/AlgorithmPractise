package BinarySearch;

public class MedianOfTwoSortedArrays {
    /*
        There are two sorted arrays nums1 and nums2 of size m and n respectively.
        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
        You may assume nums1 and nums2 cannot be both empty.

        Example 1:
        nums1 = [1, 3]
        nums2 = [2]
        The median is 2.0

        Example 2:
        nums1 = [1, 2]
        nums2 = [3, 4]
        The median is (2 + 3)/2 = 2.5
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int l = 0, r = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int med1 = 0, med2 = 0;

        while (l <= r) {
            //i + j = m − i + n − j,
            //j = (m + n + 1) / 2 - i
            int i = (l + r) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_iminus1, nums_i, nums_jminus1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_iminus1 = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
            int nums_i = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums_jminus1 = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
            int nums_j = j == n ? Integer.MAX_VALUE : nums2[j];

            if (nums_iminus1 <= nums_j) {
                med1 = Math.max(nums_iminus1, nums_jminus1);
                med2 = Math.min(nums_i, nums_j);
                l = i + 1;
            } else {
                r = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (med1 + med2) / 2.0 : med1;
    }

}
