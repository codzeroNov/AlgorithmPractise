package DP;

public class FibonacciNumber {
    public int fib(int N) {
        if (N <= 1)
            return N;

        int n = 1, n_1 = 0, sum = 0;
        while (N-- > 1) {
            sum = n + n_1;
            n_1 = n;
            n = sum;
        }

        return  sum;
    }
}
