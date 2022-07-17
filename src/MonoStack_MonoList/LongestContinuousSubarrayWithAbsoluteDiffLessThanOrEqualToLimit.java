package MonoStack_MonoList;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    /**
     * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
     *
     * **/

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new LinkedList<>(), mind = new LinkedList<>();
        int l = 0, res = 0;

        for (int r = 0; r < nums.length; r++) {
            while (!maxd.isEmpty() && maxd.peekLast() < nums[r])
                maxd.pollLast();
            maxd.offer(nums[r]);

            while(!mind.isEmpty() && mind.peekLast() > nums[r])
                mind.pollLast();
            mind.offer(nums[r]);

            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[l]) maxd.pollFirst();
                if (mind.peek() == nums[l]) mind.pollFirst();
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
