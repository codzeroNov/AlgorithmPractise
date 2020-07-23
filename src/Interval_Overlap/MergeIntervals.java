package Interval_Overlap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
/*

    Given a collection of intervals, merge all overlapping intervals.

    Example 1:
    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

    Example 2:
    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return intervals;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        List<int[]> res = new ArrayList<>();
        int preStart = intervals[0][0], preEnd = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= preEnd)
                preEnd = Math.max(preEnd, interval[1]);
            else {
                res.add(new int[]{preStart, preEnd});
                preStart = interval[0];
                preEnd = interval[1];
            }
        }
        res.add(new int[]{preStart, preEnd});

        return res.toArray(new int[0][]);
    }

}
