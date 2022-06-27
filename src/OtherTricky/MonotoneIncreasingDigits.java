package OtherTricky;

public class MonotoneIncreasingDigits {
    /*
    Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

    (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
     */

    public int monotoneIncreasingDigits(int N) {
            char[] nums = String.valueOf(N).toCharArray();
            int last = nums.length - 1;

            for (int i = last; i > 0; i--) {
                if (nums[i - 1] > nums[i]) {
                    last = i - 1;
                    nums[i - 1]--;
                }
            }

            for (int i = last + 1; i < nums.length; i++) {
                nums[i] = '9';
            }

            return Integer.parseInt(new String(nums));
    }
}
