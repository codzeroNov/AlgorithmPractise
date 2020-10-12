package BitManipulation;

public class CountingBits {
    /*
    Given a non negative integer number num.
    For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
     */

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
