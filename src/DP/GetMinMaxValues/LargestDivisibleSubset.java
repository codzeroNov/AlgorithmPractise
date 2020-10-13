package DP.GetMinMaxValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    /*
    Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

    Si % Sj = 0 or Sj % Si = 0.

    If there are multiple solutions, return any subset is fine.
     */

    /*
    给定升序序列（即 E < F < G）[E, F, G]，并且该列表本身满足问题中描述的整除子集，就不必枚举该子集的所有数字，在以下两种情况：

    推论一：可除以整除子集中的最大元素的任何值，加入到子集中，可以形成另一个整除子集，即对于所有 h，若有 h % G == 0，则 [E, F, G, h] 形成新的可除子集。
    推论二：可除以整除子集中最小元素的任何值，加入到子集中，可以形成另一个整除子集，即，对于所有的 d，若有 E % d == 0，则 [d, E, F, G] 形成一个新的整除子集。
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++)
            lists.add(new ArrayList<>());

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            List<Integer> max = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && max.size() < lists.get(j).size())
                    max = lists.get(j);
            }

            lists.get(i).addAll(max);
            lists.get(i).add(nums[i]);
        }

        List<Integer> res = new ArrayList<>();;
        for (int i = 0; i < n; i++) {
            if (res.size() < lists.get(i).size())
                res = lists.get(i);
        }

        return res;
    }
}
