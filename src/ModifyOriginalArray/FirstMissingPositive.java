package ModifyOriginalArray;

public class FirstMissingPositive {
    //Given an unsorted integer array, find the smallest missing positive integer.
    public int firstMissingPositive(int[] nums) {
        /**
         * 长度为N的数组，如果最小的缺失正数不在[1, N]中，则最小缺失正数为N+1
         *
         * 1. 令所有负数为N + 1
         *
         * 2. 将<=N的元素对应下标的数变为负数
         *
         * 3. 返回第一个元素大于零的下标
         */
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0)
                nums[i] = n + 1;
        }

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (idx < n && nums[idx] > 0)
                nums[idx] = - nums[idx];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }

        return n + 1;
    }
}
