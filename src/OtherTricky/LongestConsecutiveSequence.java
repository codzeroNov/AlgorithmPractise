package OtherTricky;

import java.util.HashSet;

public class LongestConsecutiveSequence {
/*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    Your algorithm should run in O(n) complexity.

    Example:
    Input: [100, 4, 200, 1, 3, 2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                int pointer = num;
                while (set.remove(pointer - 1))
                    pointer--;
                int left = num - pointer;

                pointer = num;
                while (set.remove(pointer + 1))
                    pointer++;
                int right = pointer - num;

                max = Math.max(max, right + left + 1);
            }
        }

        return max;
    }

}
