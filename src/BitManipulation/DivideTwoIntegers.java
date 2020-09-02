package BitManipulation;

public class DivideTwoIntegers {
    /*
        Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

        Return the quotient after dividing dividend by divisor.

        The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
    */

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long dvd = Math.abs((long)dividend), dvs = Math.abs((long)divisor);
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        int ans = 0;

        while (dvd >= dvs) {
            long temp = dvs, multi = 1;
            while (dvd >= temp << 1) {
                temp <<= 1;
                multi <<= 1;
            }
            dvd -= temp;
            ans += multi;
        }

        return sign > 0 ? ans : -ans;
    }
}
