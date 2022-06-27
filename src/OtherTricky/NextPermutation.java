package OtherTricky;

public class NextPermutation {

    // similar to next greater element iii

    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }


        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i])
            j--;

        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index;

        for (index = len-1; index > 0; index--)
            if (nums[index - 1] < nums[index])
                break;

        if (index == 0) {
            reverse(nums, 0, len - 1);
            return;
        }

        int val = nums[index-1];
        for (int i = len-1; i >= index; i--) {
            if (nums[i] > val) {
                swap(nums, index-1, i);
                break;
            }
        }

        reverse(nums, index, len-1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }
}
