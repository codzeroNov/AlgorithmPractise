package Stack;

import java.util.Stack;

public class Pattern132 {
/*
    Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
    Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

    Note: n will be less than 15,000.

    Example 1:
    Input: [1, 2, 3, 4]
    Output: False
    Explanation: There is no 132 pattern in the sequence.

    Example 2:
    Input: [3, 1, 4, 2]
    Output: True
    Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

    Example 3:
    Input: [-1, 3, 2, 0]
    Output: True
    Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
    */

    class Pair {
        int min, max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        for (int n : nums) {
            if (stack.isEmpty() || n < stack.peek().min)
                stack.push(new Pair(n, n));
            else if (n > stack.peek().min) {
                Pair last = stack.pop();
                if (n < last.max) return true;
                else {
                    last.max = n;
                    while (!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    // At this time, n < stack.peek().max (if stack not empty)
                    if (!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }

            }
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {
        //ai, aj, ak
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() >= num) break;//ai >= ak
                    stack.pop();//pop ai
                    if (stack.pop() > num) return true;//aj > ak
                }
                //push max first then push min using the same stack.
                stack.push(num);
                stack.push(min);
            }
        }
        return false;
    }
}
