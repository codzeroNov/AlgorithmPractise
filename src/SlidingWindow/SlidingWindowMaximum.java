package SlidingWindow;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {

/*
    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
    You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    Return the max sliding window.

    Follow up:
    Could you solve it in linear time?

    Example:

    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
    Output: [3,3,5,5,6,7]

    Explanation:
        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7      3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7

    Constraints:
            1 <= nums.length <= 10^5
            -10^4 <= nums[i] <= 10^4
            1 <= k <= nums.length

*/

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length * k == 0) return new int[0];
        if (k == 1) return nums;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = nums.length, maxId = 0;
        //init max index
        for (int i = 0; i < k; i++) {
            if (!deque.isEmpty() && nums[i] > nums[deque.getFirst()])
                maxId = i;
            cleanDeque(deque, nums, i, k);
            deque.addLast(i);
        }

        int[] output = new int[len - k + 1];
        output[0] = nums[maxId];

        for (int i = k; i < len; i++) {
            cleanDeque(deque, nums, i, k);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }

        return output;
    }

    private void cleanDeque(ArrayDeque<Integer> deque, int[] nums, int i, int k) {
        if (!deque.isEmpty() && deque.getFirst() == i - k)
            deque.removeFirst();
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()])
            deque.removeLast();
    }

}
