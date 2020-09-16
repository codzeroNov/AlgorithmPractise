package OtherTricky;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    /**
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     *
     * Find all the elements that appear twice in this array.
     *
     * Could you do it without extra space and in O(n) runtime?
     *
     */

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0)
                res.add(idx + 1);
            nums[idx] = -nums[idx];
        }

        return res;
    }
}
