package OtherTricky;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    //Given a list of non-negative integers, arrange them such that they form the largest number.
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strNums[i] = String.valueOf(nums[i]);

        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(strNums, comparator);

        if (strNums[0].charAt(0) == '0')
            return "0";

        StringBuffer res = new StringBuffer();
        for (String s : strNums)
            res.append(s);

        return res.toString();
    }
}
