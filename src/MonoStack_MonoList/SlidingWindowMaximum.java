package MonoStack_MonoList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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
        // https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
        // monotonous deque

        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1)
                q.poll();

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();

            q.offer(i);
            if (i + 1 >= k)
                res[i - k + 1] = nums[q.peek()];
        }

        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
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
