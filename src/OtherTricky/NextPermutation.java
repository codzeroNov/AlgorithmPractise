package OtherTricky;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index;

        for (index = len-1; index > 0; index--)
            if (nums[index - 1] < nums[index])
                break;

        if (index == 0) {
            reverseSort(nums, 0, len - 1);
            return;
        }

        int val = nums[index-1];
        for (int i = len-1; i >= index; i--) {
            if (nums[i] > val) {
                swap(nums, index-1, i);
                break;
            }
        }

        reverseSort(nums, index, len-1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }

    private void reverseSort(int[] nums, int l, int r) {
        while (l < r)
            swap(nums, l++, r--);
    }
}
