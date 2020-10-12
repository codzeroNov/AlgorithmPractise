package OtherTricky;

public class CountNumbersWithUniqueDigits {
    /*
    Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
     */

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int res = 10;
        int uniqueDigits = 9, availableNum = 9;
        while (n-- > 1 && availableNum > 0) {
            uniqueDigits *= availableNum;
            res += uniqueDigits;
            availableNum--;
        }

        return res;
    }
}
