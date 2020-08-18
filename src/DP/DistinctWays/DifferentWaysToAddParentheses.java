package DP.DistinctWays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {
    /*
        Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
        The valid operators are +, - and *.

        Example 1:
        Input: "2-1-1"
        Output: [0, 2]
        Explanation:
        ((2-1)-1) = 0
        (2-(1-1)) = 2
    */

    // recursive without memorization
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0)
            return res;

        int num = 0, idx = 0;
        while (idx < input.length() && Character.isDigit(input.charAt(idx))) {
            num = num * 10 + input.charAt(idx) - '0';
            idx++;
        }

        if (idx == input.length()) { // check if input string is purely a number
            res.add(num);
            return res;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // if met with operation char, cut it into two parts to calculate
            if (!Character.isDigit(c)) {
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));
                for (int p1 = 0; p1 < list1.size(); p1++) {
                    for (int p2 = 0; p2 < list2.size(); p2++) {
                        res.add(calculate(list1.get(p1), list2.get(p2), c));
                    }
                }
            }
        }

        return res;
    }

    private int calculate(Integer num1, Integer num2, char op) {
        switch (op) {
            case '+' :
                return num1 + num2;

            case '-' :
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return -1;
    }

    // with memorization
    Map<String, List> map = new HashMap<>();
    public List<Integer> diffWaysToCompute2(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0)
            return res;

        if (map.containsKey(input))
            return map.get(input);

        int num = 0, idx = 0;
        while (idx < input.length() && Character.isDigit(input.charAt(idx))) {
            num = num * 10 + input.charAt(idx) - '0';
            idx++;
        }

        if (idx == input.length()) { // check if input string is purely a number
            res.add(num);
            map.put(input, res);
            return res;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // if met with operation char, cut it into two parts to calculate
            if (!Character.isDigit(c)) {
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));
                for (int p1 = 0; p1 < list1.size(); p1++) {
                    for (int p2 = 0; p2 < list2.size(); p2++) {
                        res.add(calculate(list1.get(p1), list2.get(p2), c));
                    }
                }
            }
        }

        return res;
    }

    // dp
    public List<Integer> diffWaysToCompute3(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0)
            return res;

        // get nums and ops list
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                continue;
            }
            nums.add(num);
            num = 0;
            ops.add(c);
        }
        nums.add(num);

        // initialize dp array
        int N = nums.size();
        ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = new ArrayList<>();
            dp[i][i].add(nums.get(i));
        }

        // iterate from 2 to N
        for (int n = 2; n <= N; n++) {
            for (int l = 0; l < N; l++) {
                int r = l + n - 1;
                if (r >= N) break;
                ArrayList<Integer> sub = new ArrayList<>();

                for (int opIdx = l; opIdx < r; opIdx++) {
                    List<Integer> list1 = dp[l][opIdx];
                    List<Integer> list2 = dp[opIdx + 1][r];
                    for (int p1 = 0; p1 < list1.size(); p1++) {
                        for (int p2 = 0; p2 < list2.size(); p2++) {
                            char op = ops.get(opIdx);
                            sub.add(calculate(list1.get(p1), list2.get(p2), op));
                        }
                    }
                }
                dp[l][r] = sub;
            }
        }

        return dp[0][N - 1];
    }
}
