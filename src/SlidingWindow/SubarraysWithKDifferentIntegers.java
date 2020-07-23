package SlidingWindow;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
/*
    Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the
    number of different integers in that subarray is exactly K.

    (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

    Return the number of good subarrays of A.



    Example 1:
    Input: A = [1,2,1,2,3], K = 2
    Output: 7
    Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

    Example 2:
    Input: A = [1,2,1,3,4], K = 3
    Output: 3
    Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].


    Note:

            1 <= A.length <= 20000
            1 <= A[i] <= A.length
            1 <= K <= A.length
    */
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    private int atMostK(int[] nums, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0, i = 0, j = 0;
        while (j < nums.length) {

            int right = nums[j];
            if (map.getOrDefault(right, 0) == 0)
                K--;
            map.put(right, map.getOrDefault(right, 0 ) + 1);

            while (K < 0) {
                int left = nums[i];
                map.put(left, map.getOrDefault(left, 0) - 1);
                if (map.get(left) == 0)
                    K++;
                i++;
            }
            j++;
            res += j - i + 1;
        }
        return res;
    }
}
