package Heap;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
    /**
     * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
     *
     * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
     * **/

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }

        int start = 0, end = Integer.MAX_VALUE;
        while (pq.size() == nums.size()) {
            int[] curr = pq.poll();
            int val = curr[0], row = curr[1], pos = curr[2];
            if (max - val < end - start) {
                end = max;
                start = val;
            }
            if (pos + 1 < nums.get(row).size()) {
                int next = nums.get(row).get(pos + 1);
                pq.offer(new int[]{next, row, pos + 1});
                max = Math.max(next, max);
            }
        }

        return new int[]{start, end};
    }
}
