package BinarySearch;

public class FindMinimumInRotatedSortedArray {

/*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
    Find the minimum element.
    You may assume no duplicate exists in the array.
*/


    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            if (nums[l] <= nums[mid] && nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return nums[l];
    }

    /**
     * (1) loop is left < right, which means inside the loop, left always < right
     * (2 ) since we use round up for mid, and left < right from (1), right would never be the same as mid
     * (3) Therefore, we compare mid with right, since they will never be the same from (2)
     * (4) if nums[mid] < nums[right], we will know the minimum should be in the left part, so we are moving right.
     * We can always make right = mid while we don't have to worry the loop will not ends. Since from (2), we know right would never be the same as mid, making right = mid will assure the interval is shrinking.
     * (5) if nums[mid] > nums[right], minimum should be in the right part, so we are moving left. Since nums[mid] > nums[right],mid can't be the minimum, we can safely move left to mid + 1, which also assure the interval is shrinking
     */
    public int findMin2(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < nums[r])
                r = mid;
            else if (nums[mid] > nums[r])
                l = mid + 1;
        }

        return nums[l];
    }
}
