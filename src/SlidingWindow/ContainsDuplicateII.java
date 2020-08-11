package SlidingWindow;

import java.util.HashMap;

public class ContainsDuplicateII {
    /*
        Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
        such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;

        HashMap<Integer, Integer> val2idx = new HashMap<>();
        for (int i = 0;i < nums.length; i++) {
            if (!val2idx.containsKey(nums[i])) {
                val2idx.put(nums[i], i);
            } else if (i - val2idx.get(nums[i]) <= k) {
                return true;
            }
            if (val2idx.size() > k) {
                val2idx.remove(nums[i - k]);
            }
        }

        return false;
    }
}
