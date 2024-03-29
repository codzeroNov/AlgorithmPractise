package DP;

public class NumberOfPeopleAwareOfASecret {
    /**
     * On day 1, one person discovers a secret.
     *
     * You are given an integer delay, which means that each person will share the secret with a new person every day, starting from delay days after discovering the secret. You are also given an integer forget, which means that each person will forget the secret forget days after discovering it. A person cannot share the secret on the same day they forgot it, or on any day afterwards.
     *
     * Given an integer n, return the number of people who know the secret at the end of day n. Since the answer may be very large, return it modulo 109 + 7.
     * **/

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long MOD = 1000000007, share = 0, res = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = share = share + (i > delay ? dp[i - delay] : 0) - (i > forget ? dp[i - forget] : 0);
            dp[i] %= MOD;
        }

        for (int i = n - forget + 1; i <= n; i++)
            res = (res + dp[i]) % MOD;

        return (int)res;
    }
}
