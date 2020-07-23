package OtherTricky;

public class SortColors {

    public void sortColors(int[] nums) {
        int zeros = 0, seconds = nums.length;

        for (int i = 0; i <= seconds; i++) {
            while (nums[i] == 2 && i < seconds) swap(nums,i, seconds--);
            while (nums[i] == 0 && i > zeros) swap(nums, i, zeros++);
        }

        return;
    }

    private void swap(int[]nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

}
