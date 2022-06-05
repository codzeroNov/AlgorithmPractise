package DP;

import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses {
/*
    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

    示例 1:
    输入: "(()"
    输出: 2
    解释: 最长有效括号子串为 "()"

    示例 2:
    输入: ")()())"
    输出: 4
    解释: 最长有效括号子串为 "()()"
*/


    public int longestValidParentheses(String s) {
        //dp[i]=dp[i−2]+2
        //dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
        int[] dp = new int[s.length()];
        int max = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i > dp[i - 1] && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i >= dp[i - 1] + 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }

    public int longestValidParentheses2(String s) {
        int left = 0, right = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                max = Math.max(max, 2 * right);
            if (right > left)
                left = right = 0;
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                max = Math.max(max, 2 * left);
            if (left > right)
                left = right = 0;
        }

        return max;
    }


    public int longestValidParentheses3(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;

        for (int i  = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, i - stack.peek());
            } else {
                stack.push(i);
            }
        }

        return max;
    }

}
