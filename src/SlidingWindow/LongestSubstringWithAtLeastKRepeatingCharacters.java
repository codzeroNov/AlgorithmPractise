package SlidingWindow;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    /*
    Find the length of the longest substring T of a given string (consists of lowercase letters only)
    such that every character in T appears no less than k times.
     */
    public int longestSubstring(String s, int k) {
        // https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/solution/xiang-jie-mei-ju-shuang-zhi-zhen-jie-fa-50ri1/
        int max = 0;

        for (int i = 0; i < 26; i++)
            max = Math.max(max, longestSubstringWithNUniqueDigits(s, k, i));

        return max;
    }

    private int longestSubstringWithNUniqueDigits(String s, int k, int n) {
        int length = 0, uniqueCount = 0, noLessThanKCount = 0;
        int begin = 0, end = 0;
        int[] map = new int[128];

        while (end < s.length()) {
            if (map[s.charAt(end)]++ == 0) uniqueCount++;
            if (map[s.charAt(end++)] == k) noLessThanKCount++;

            while (uniqueCount > n) {
                if (map[s.charAt(begin)]-- == k) noLessThanKCount--;
                if (map[s.charAt(begin++)] == 0) uniqueCount--;
            }

            if (uniqueCount == n && uniqueCount == noLessThanKCount) {
                length = Math.max(length, end - begin);
            }
        }

        return length;

    }
}
