package Greedy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberofKConsecutiveBitFlips {
/*
    In an array A containing only 0s and 1s,
    a K-bit flip consists of choosing a (contiguous) subarray of length K and simultaneously changing every 0 in the subarray to 1,
    and every 1 in the subarray to 0.

    Return the minimum number of K-bit flips required so that there is no 0 in the array.  If it is not possible, return -1.

    Example 1:
    Input: A = [0,1,0], K = 1
    Output: 2
    Explanation: Flip A[0], then flip A[2].

    Example 2:
    Input: A = [1,1,0], K = 2
    Output: -1
    Explanation: No matter how we flip subarrays of size 2, we can't make the array become [1,1,1].

    Example 3:
    Input: A = [0,0,0,1,0,1,1,0], K = 3
    Output: 3
    Explanation:
    Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
    Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
    Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]

    Note:
            1 <= A.length <= 30000
            1 <= K <= A.length
*/

//Minimum Number of K Consecutive Bit Flips

    public int minKBitFlips(int[] A, int K) {
/*
        Explanation
        Create a new array isFlipped[n].
        isFlipped[i] = 1 if we flip K consecutive bits starting at A[i].

        We maintain a variable flipped and flipped = 1 if the current bit is flipped.

        If flipped = 0 and A[i] = 0, we need to flip at A[i].
        If flipped = 1 and A[i] = 1, we need to flip at A[i].
*/
        int n = A.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];

        for (int i = 0; i < n; ++i) {
            if (i >= K)
                flipped ^= isFlipped[i - K];
            if (flipped == A[i]) {
                if (i + K > A.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }

        return res;
    }

    public int minKBitFlips2(int[] A, int K) {
        int len = A.length;
        int count = 0;
        LinkedList<Integer> sw = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (!sw.isEmpty() && sw.peek() == i - K)
                sw.remove(0);
            if (sw.size() % 2 == A[i]) {
                if (i + K > len)
                    return -1;
                sw.add(i);
                count++;
            }
        }
        return count;
    }

    public int minKBitFlips3(int[] nums, int k) {
        int res = 0, n = nums.length;
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if ((q.size() % 2 == 0 && nums[i] == 0) || (q.size() % 2 == 1 && nums[i] == 1)) {
                res++;
                if (i + k > n)
                    return -1;
                q.offer(i + k - 1);
            }
            while (q.size() > 0 && q.peek() <= i)
                q.remove();

        }

        return res;
    }

}
