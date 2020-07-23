package OtherTricky;

public class FindMinimumInRotatedSortedArray {

/*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
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
}
