package OtherTricky;

import java.util.LinkedList;
import java.util.List;

public class MajorityElementII {
    /*
        Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    
        Note: The algorithm should run in linear time and in O(1) space.
    */

    //Boyer-Moore Majority Vote algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return list;

        int candidate1 = 0, count1 = 0, candidate2 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++; // use "else if" in case candidates are the same
        }
        if (count1 > nums.length / 3) list.add(candidate1);
        if (count2 > nums.length / 3) list.add(candidate2);

        return list;
    }

}
