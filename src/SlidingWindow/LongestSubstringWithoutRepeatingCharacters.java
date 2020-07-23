package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    public int lengthOfLongestSubstring(String s) {
        if (s == null && s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        char[] chars = s.toCharArray();

        while (right < s.length()) {
            while (set.contains(chars[right])) {
                if (set.contains(chars[left])) {
                    set.remove(chars[left++]);
                }
            }
            max = Math.max(right - left + 1, max);
            set.add(chars[right++]);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        char[] chars = s.toCharArray();

        while (right < s.length()) {
            if (map.containsKey(chars[right])) {
                left = Math.max(map.get(chars[right]) + 1, left);
            }
            map.put(chars[right], right);
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }

}
