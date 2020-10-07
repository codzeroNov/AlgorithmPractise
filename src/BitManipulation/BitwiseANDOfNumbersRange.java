package BitManipulation;

public class BitwiseANDOfNumbersRange {
    /*
    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
     */
    public int rangeBitwiseAnd(int m, int n) {
        /*
        1. 我们通过右移，将两个数字压缩为它们的公共前缀。在迭代过程中，我们计算执行的右移操作数。
        2. 将得到的公共前缀左移相同的操作数得到结果。
         */

        int shift = 0;
        while ( m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }

        return m << shift;
    }
}
