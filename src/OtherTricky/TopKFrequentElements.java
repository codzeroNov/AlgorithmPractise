package OtherTricky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    /*
    Given a non-empty array of integers, return the k most frequent elements.
     */

    // bucket sort
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length == 0) return res;
        // 1. get frequency
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        // 2. use bucket sort
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : freq.keySet()) {
            int frequency = freq.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList();
            bucket[frequency].add(key);
        }
        // 3. store results
        for (int f = nums.length, i = 0; f >= 0 && i < k; f--) {
            if (bucket[f] != null) {
                for (int num : bucket[f]) {
                    res[i] = num;
                    i++;
                }
            }
        }

        return res;
    }
}
