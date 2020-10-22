package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementII {

/*
    给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
    数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
    如果不存在，则输出 -1。
*/

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];

        Arrays.fill(res, -1);

        for (int index = 0; index < len * 2; index++) {
            int i = index % len;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                res[stack.pop()] = nums[i];

            stack.push(i);
        }

        return res;
    }

}
