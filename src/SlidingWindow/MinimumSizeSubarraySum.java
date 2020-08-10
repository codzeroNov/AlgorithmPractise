package SlidingWindow;

public class MinimumSizeSubarraySum {
    //Given an array of n positive integers and a positive integer s,
    //find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

    //O(N)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int l = 0, r = 0;
        int sum = 0, len = Integer.MAX_VALUE;
        for (; r < nums.length; r++) {
            sum += nums[r];

            while (sum >= s) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l++];
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }

    //O(NlogN)
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] sum = new int[nums.length + 1];

        //get a prefix sum
        for (int i = 1; i < nums.length + 1; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            int target = sum[i] + s;
            int end = biSearch(sum, i + 1, target);
            if (end == sum.length) break;
            minLen = Math.min(minLen, end - i);
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private int biSearch(int[] sum, int left, int target) {
        int right = sum.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sum[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
