package OtherTricky;

public class SingleNumberIII {
    /*
        Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
        Find the two elements that appear only once.
    */

    /*
    + In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find.
    Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result.
    Find out an arbitrary set bit (for example, the rightmost set bit).

    + In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementinoed bit unset.
    Two different numbers we need to find must fall into thte two distrinct groups. XOR numbers in each group, we can find a number in either group.
    */

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }

        diff &= -diff;// equals ~(diff - 1) = - (diff - 1) - 1 = -diff, see https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C%2B%2BJava-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations

        int[] res = {0, 0};
        for (int n : nums) {
            if ((n & diff) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }

        return res;
    }
}
