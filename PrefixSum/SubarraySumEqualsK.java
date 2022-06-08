class Solution {
    /*
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
    A subarray is a contiguous non-empty sequence of elements within an array.
    * */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1); // init the prefix map
        int sum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += prefix.getOrDefault(sum - k, 0); // not k - sum, as we accumulate the sum, the difference is added to prefix map then.
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}