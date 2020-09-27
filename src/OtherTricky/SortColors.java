package OtherTricky;

public class SortColors {

    /*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
    with the colors in the order red, white, and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     */

    public void sortColors(int[] nums) {
        int zeros = 0, seconds = nums.length;

        for (int i = 0; i <= seconds; i++) {
            while (nums[i] == 2 && i < seconds) swap(nums, i, seconds--);
            while (nums[i] == 0 && i > zeros) swap(nums, i, zeros++);
        }

        return;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

}
