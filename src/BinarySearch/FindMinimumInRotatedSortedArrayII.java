package BinarySearch;

public class FindMinimumInRotatedSortedArrayII {
    /*
        Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

        Find the minimum element.

        The array may contain duplicates.
    */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;

        while (l < r) {
            mid = (r - l) / 2 + l;
            if (nums[mid] < nums[r])
                r = mid;
            else if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r--;
        }

        return nums[l];
    }


}
