package OtherTricky;

public class WiggleSortII {
    /*
    Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
    */
    public void wiggleSort(int[] nums) {
        int mid = findKLargest(nums, nums.length / 2);
        int n = nums.length;
        int i = 0, left = 0, right = n - 1;

        while (i <= right) {
            if (nums[getMappingIndex(i, n)] > mid) {
                swap(nums, getMappingIndex(left, n), getMappingIndex(i, n));
                i++;
                left++;
            } else if (nums[getMappingIndex(i, n)] < mid) {
                swap(nums, getMappingIndex(right, n), getMappingIndex(i, n));
                right--;
            } else {
                i++;
            }
        }
    }

    private int getMappingIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private int findKLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0, right = nums.length - 1;
        int pos = 0;
        while (left < right) {
            pos = partition(nums, left, right);
            if (pos < k) {
                left = pos + 1;
            } else if (pos > k) {
                right = pos - 1;
            } else {
                break;
            }
        }
        return nums[pos];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left], i = left, j = right;

        while (i < j) {
            while (i < j && nums[j] <= pivot)
                j--;
            while (i < j && nums[i] >= pivot)
                i++;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, left);

        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        new WiggleSortII().wiggleSort(new int[]{1,5,4,4,5,1,1,5,3,4,2,4,4,1,1,1,2,4,5});
    }
}
