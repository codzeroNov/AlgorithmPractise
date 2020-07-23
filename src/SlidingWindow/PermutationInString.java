package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
/*
    Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
    In other words, one of the first string's permutations is the substring of the second string.

    Example 1:
    Input: s1 = "ab" s2 = "eidbaooo"
    Output: True
    Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:
    Input:s1= "ab" s2 = "eidboaoo"
    Output: False

    Constraints:
    The input strings only contain lower case letters.
    The length of both given strings is in range [1, 10,000].
*/


    public boolean checkInclusion1(String target, String original){
        int[] count = new int[128];

        for (int i = 0; i < target.length(); i++)
            count[target.charAt(i)]--;

        for (int l = 0, r = 0; r < original.length(); r++) {
            if (++count[original.charAt(r)] > 0)
                while (--count[original.charAt(l++)] != 0);//缩小窗口左边界
            else if ((r - l + 1) == target.length())//此时count[original.charAt(r)] == 0， 检查窗口长度
                return true;
        }
        return target.length() == 0;
    }

    public boolean checkInclusion2(String target, String original) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);


        int matchedCnt = 0;
        for (int i = 0; i < original.length(); ++i) {
            //右边界
            char c = original.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    matchedCnt++;
            }
            //左边界
            if (i >= target.length()) {
                c = original.charAt(i - target.length());
                if (map.containsKey(c)) {
                    if (map.get(c) == 0)
                        matchedCnt--;
                    map.put(c, map.get(c) + 1);
                }
            }

            if (matchedCnt == map.size()) {
                return true;
            }
        }
        return false;
    }
}
