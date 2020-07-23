package OtherTricky;

public class Pow_x_n {

    //实现 pow(x, n) ，即计算 x 的 n 次幂函数。

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            x *= x;
            n /= 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

}
