package Stack;

import java.util.Stack;

public class RemoveKDigits {
    /*
        Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

        Note:
        The length of num is less than 10002 and will be ≥ k.
        The given num does not contain any leading zero.
    */
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len <= k) return "0";

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.add(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse();

        while (res.length() > 1 && res.charAt(0) == '0')
            res.deleteCharAt(0);

        return res.toString();
    }
}
