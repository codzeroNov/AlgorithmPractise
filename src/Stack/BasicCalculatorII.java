package Stack;

import java.util.Stack;

public class BasicCalculatorII {
    /*
        Implement a basic calculator to evaluate a simple expression string.
        The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
    */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        char prevSign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if ((!Character.isDigit(c) && c != ' ' ) || i == s.length() - 1) {
                if (prevSign == '+')
                    stack.push(num);
                if (prevSign == '-')
                    stack.push(-num);
                if (prevSign == '*')
                    stack.push(stack.pop() * num);
                if (prevSign == '/')
                    stack.push(stack.pop() / num);
                prevSign = c;
                num = 0;
            }
        }

        int ans = 0;
        for (int i : stack)
            ans += i;

        return ans;
    }

    // without stack
    public int calculate2(String s) {
        if (s == null || s.length() == 0) return 0;

        char prevSign = '+';
        int num = 0, sum = 0, prevSum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (prevSign) {
                    case '+':
                        sum += prevSum;
                        prevSum = num;
                        break;
                    case '-':
                        sum += prevSum;
                        prevSum = -num;
                        break;
                    case '*':
                        prevSum *= num;
                        break;
                    case '/':
                        prevSum /= num;
                        break;
                }
                prevSign = c;
                num = 0;
            }
        }
        sum += prevSum;

        return sum;
    }
}
