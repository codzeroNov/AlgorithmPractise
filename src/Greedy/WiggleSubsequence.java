package Greedy;

public class WiggleSubsequence {
    /*
        A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative.
        The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

        For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
        In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

        Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
        A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

    */

    /**
     * {@link OtherTricky.LongestTurbulentSubarray}
     * greedy approach
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) up = down + 1;
            if (nums[i] < nums[i - 1]) down = up + 1;
        }

        return Math.max(up, down);
    }

    //greedy
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2) return nums.length;

        int prevdiff = nums[1] - nums[0];
        int count = prevdiff == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int currdiff = nums[i] - nums[i - 1];
            if ((currdiff > 0 && prevdiff <= 0) || (currdiff < 0 && prevdiff >= 0)) { // using >= or <= here means that
                count++;
                prevdiff = currdiff;
            }
        }

        return count;
    }

    // dp
    public int wiggleMaxLength3(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return len;

        int[] up = new int[len], down = new int[len];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    up[i] = Math.max(up[i], down[j] + 1);
                else if (nums[i] < nums[j])
                    down[i] = Math.max(down[i], up[j] + 1);
            }
        }

        return Math.max(up[len - 1], down[len - 1]);
    }

    public int wiggleMaxLength4(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;

        int[] up = new int[len], down = new int[len];
        up[0] = down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }

        return Math.max(up[len - 1], down[len - 1]);
    }

}
