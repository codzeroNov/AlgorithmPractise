package OtherTricky;

public class FindFirstAndLastPositionOfElementInSortedArray {

/*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

    你的算法时间复杂度必须是 O(log n) 级别。

    如果数组中不存在目标值，返回 [-1, -1]。
*/


    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        if (nums == null || nums.length == 0)
            return ret;

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;//mid is biased to left
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }

        if (nums[l] != target) return ret;

        ret[0] = l;

        r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1; //tricky, let mid become biased to right
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid;
        }
        ret[1] = r;

        return ret;
    }

}
