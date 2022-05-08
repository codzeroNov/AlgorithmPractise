package BackTrack;

import java.math.BigInteger;

public class AdditiveNumber {
    /*
        Additive number is a string whose digits can form additive sequence.

        A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

        Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

        Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

        Example 1:
        Input: "112358"
        Output: true
        Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
        1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
    */
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger x = new BigInteger(num.substring(0, i));
            // the longest length in two nums must at least equal to the length of their sum
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) break;
                BigInteger y = new BigInteger(num.substring(i, i + j));
                if (isValid(x, y, i + j, num))
                    return true;
            }
        }

        return false;
    }

    private boolean isValid(BigInteger x, BigInteger y, int start, String num) {
        if (start == num.length()) return true;
        y = x.add(y); // sum
        x = y.subtract(x); // the previous y
        String sum = y.toString();
        return num.startsWith(sum, start) && isValid(x, y, start + sum.length(), num);
    }

    public boolean isAdditiveNumber2(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (isValid(num, i, j))
                    return true;
            }
        }

        return false;
    }

    private boolean isValid(String num, int i, int j) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        BigInteger x = new BigInteger(num.substring(0, i));
        BigInteger y = new BigInteger(num.substring(i, i + j));
        String sum;

        for (int start = i + j; start < num.length(); start += sum.length()) {
            y = y.add(x);
            x = y.subtract(x);
            sum = y.toString();
            if (!num.startsWith(sum, start))
                return false;
        }

        return true;
    }


}
