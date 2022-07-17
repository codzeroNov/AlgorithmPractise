package OtherTricky;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MaxSumOfAPairWithEqualSumOfDigits {
    /**
     * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
     *
     * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
     * **/
    public int maximumSum(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = getKey(nums[i]);
            if (map.get(key) == null)
                map.put(key, new ArrayList<>());
            map.get(key).add(nums[i]);
        }

        int max = -1;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() < 2)
                continue;
            list.sort(Comparator.reverseOrder());
            max = Math.max(max, list.get(0) + list.get(1));
        }

        return max;
    }

    private int getKey(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

}
