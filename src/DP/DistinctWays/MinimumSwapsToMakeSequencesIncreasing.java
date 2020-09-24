package DP.DistinctWays;

public class MinimumSwapsToMakeSequencesIncreasing {
/*
    We have two integer sequences A and B of the same non-zero length.
    We are allowed to swap elements A[i] and B[i]. Note that both elements are in the same index position in their respective sequences.
    At the end of some number of swaps, A and B are both strictly increasing. (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
    Given A and B, return the minimum number of swaps to make both sequences strictly increasing. It is guaranteed that the given input always makes it possible.

    Example:
    Input: A = [1,3,5,4], B = [1,2,3,7]
    Output: 1
    Explanation:
    Swap A[3] and B[3].  Then the sequences are:
    A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
    which are both strictly increasing.

    Note:
    A, B are arrays with the same length, and that length will be in the range [1, 1000].
    A[i], B[i] are integer values in the range [0, 2000].
*/

    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[N], notSwap = new int[N];
        swap[0] = 1;

        for (int i = 1; i < N; i++) {
            swap[i] = notSwap[i] = N;
            /**
             * 1. A[i - 1] < A[i] && B[i - 1] < B[i].
             * In this case, if we want to keep A and B increasing before the index i, can only have two choices.
             * -> 1.1 don't swap at (i-1) and don't swap at i, we can get not_swap[i] = not_swap[i-1]
             * -> 1.2 swap at (i-1) and swap at i, we can get swap[i] = swap[i-1]+1
             * if swap at (i-1) and do not swap at i, we can not guarantee A and B increasing.
             *
             * 2. A[i-1] < B[i] && B[i-1] < A[i]
             * In this case, if we want to keep A and B increasing before the index i, can only have two choices.
             * -> 2.1 swap at (i-1) and do not swap at i, we can get notswap[i] = Math.min(swap[i-1], notswap[i] )
             * -> 2.2 do not swap at (i-1) and swap at i, we can get swap[i]=Math.min(notswap[i-1]+1, swap[i])
             */
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap[i] = swap[i - 1] + 1;
                notSwap[i] = notSwap[i - 1];
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                swap[i] = Math.min(notSwap[i - 1] + 1, swap[i]);
                notSwap[i] = Math.min(swap[i - 1], notSwap[i]);
            }
        }

        return Math.min(swap[N - 1], notSwap[N - 1]);
    }
}
