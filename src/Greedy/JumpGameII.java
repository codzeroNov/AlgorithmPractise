package Greedy;

public class JumpGameII {
    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.

    Note:
    You can assume that you can always reach the last index.
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int steps = 0, position = nums.length - 1;
        while (position != 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    steps++;
                    position = i;
                    break;
                }
            }
        }

        return steps;
    }

    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int steps = 0, max = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {// subtract 1, be aware of the first position doesn't count
            max = Math.max(i + nums[i], max);
            if (i == end) {
                steps++;
                end = max;
            }
        }

        return steps;
    }
}
