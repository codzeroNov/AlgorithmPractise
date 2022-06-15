package BitManipulation;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {

    /*
        The gray code is a binary numeral system where two successive values differ in only one bit.
        Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
        A gray code sequence must begin with 0.
    */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        res.add(0);

        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }

        return res;
    }
}
