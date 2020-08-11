package SlidingWindow;

import java.util.HashMap;
import java.util.TreeSet;

public class ContainsDuplicateIII {
    /*
        Given an array of integers, find out whether there are two distinct indices i and j in the array
        such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

    */
    //tree, space:O(k), time:O(nlogk)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0)
            return false;

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //get ceiling diff
            Integer ceil = treeSet.ceiling(nums[i]);
            if (ceil != null && ceil <= t + nums[i]) // do not use ceil-nums[i]<=t to prevent overflow
                return true;
            //get floor diff
            Integer floor = treeSet.floor(nums[i]);
            if (floor != null && nums[i] <= t + floor)
                return true;

            treeSet.add(nums[i]);
            if (treeSet.size() > k)
                treeSet.remove(nums[i - k]);
        }
        return false;
    }

    //bucket sort, space:O(t), time:O(t)
    private long getId(long num, long width) {
        // make negative num do not shrinks towards 0
        return num < 0 ? (num + 1) / width - 1 : num / width;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (t < 0)
            return false;

        HashMap<Long, Long> map = new HashMap<>();
        long w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long bucket = getId(nums[i], w);
            if (map.containsKey(bucket))
                return true;
            if (map.containsKey(bucket - 1) && Math.abs(map.get(bucket - 1) - nums[i]) < w)
                return true;
            if (map.containsKey(bucket + 1) && Math.abs(map.get(bucket + 1) - nums[i]) < w)
                return true;

            map.put(bucket, (long)nums[i]);
            if (i >= k)
                map.remove(getId(nums[i - k], w));
        }

        return false;
    }
}
