package OtherTricky;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NumbersWithRepeatedDigits {
    /**
     * Given an integer n, return the number of positive integers in the range [1, n] that have at least one repeated digit.
     * **/

    public int numDupDigitsAtMostN(int n) {
        List<Integer> numberArray = new LinkedList<>();

        for (int x = n + 1; x > 0; x /= 10)
            numberArray.add(0, x % 10);

        int N = numberArray.size(), res = 0;
        for (int i = 1; i < N; i++)
            res += 9 * permutation(9, i - 1);

        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i > 0 ? 0 : 1; j < numberArray.get(i); j++)
                if (!seen.contains(j))
                    res += permutation(9 - i, N - i - 1);

            if (seen.contains(numberArray.get(i))) break;
            seen.add(numberArray.get(i));
        }

        return n - res;
    }

    private int permutation(int m, int n) {
        int p = 1;
        for (int i = 0; i < n; i++)
            p *= m--;
        return p;
    }
}
