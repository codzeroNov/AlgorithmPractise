package OtherTricky;

public class NextGreaterElementIII {

    //给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。

    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();

        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1])
            i--;

        if (i < 0) return -1;

        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i])
            j--;

        swap(nums, i, j);
        reverse(nums, i + 1, nums.length-1);

        try {
            return Integer.parseInt(String.valueOf(nums));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void reverse(char[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
