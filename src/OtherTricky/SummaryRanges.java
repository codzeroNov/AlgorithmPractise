package OtherTricky;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    /*
        Given a sorted integer array without duplicates, return the summary of its ranges.

        Example 1:
        Input:  [0,1,2,4,5,7]
        Output: ["0->2","4->5","7"]
        Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
    */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                end++;
                i++;
            }

            if (start == end) {
                list.add(String.valueOf(nums[i]));
            } else {
                list.add(nums[start] + "->" + nums[end]);
            }
            end++;
            start = end;
        }
        return list;
    }

}
