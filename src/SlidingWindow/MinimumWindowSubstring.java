package SlidingWindow;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWindowSubstring {

/*  https://leetcode.com/problems/minimum-window-substring/
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    Example:

    Input: S = "ADOBECODEBANC", T = "ABC"
    Output: "BANC"
    Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0)
            return "";

        HashMap<Character, Integer> target = new HashMap<>();
        for (Character c : t.toCharArray())
            target.put(c, target.getOrDefault(c, 0) + 1);

        HashMap<Character, Integer> window = new HashMap<>();
        int count = 0;
        int l = 0;
        int[] pos = new int[]{-1, 0, 0};//pos[0] -> len of substring, pos[1] -> start of substring, pos[2] -> end of substring

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (target.containsKey(c) && window.get(c).intValue() == target.get(c).intValue()) {
                count++;
            }
            while (l <= r && count == target.size()) {
                if (pos[0] == -1 || r - l + 1 < pos[0]) {
                    pos[0] = r - l + 1;
                    pos[1] = l;
                    pos[2] = r;
                }
                c = s.charAt(l);
                window.put(c, window.get(c) - 1);
                if (target.containsKey(c) && window.get(c).intValue() < target.get(c).intValue()) {
                    count--;
                }
                l++;
            }
        }
        return pos[0] == -1 ? "" : s.substring(pos[1], pos[2] + 1);
    }

    public String minWindow2(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";

        HashMap<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray())
            target.put(c, target.getOrDefault(c, 0) + 1);

        ArrayList<Pair<Integer, Character>> filterS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (target.containsKey(c))
                filterS.add(new Pair<>(i, c));
        }

        int l = 0, r = 0, count = 0;
        int[] pos = new int[]{-1, 0, 0};
        HashMap<Character, Integer> window = new HashMap<>();
        while (r < filterS.size()) {
            char c = filterS.get(r).getValue();
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).intValue() == target.get(c).intValue())
                count++;
            while (count == target.size()) {
                c = filterS.get(l).getValue();
                int start = filterS.get(l).getKey();
                int end = filterS.get(r).getKey();
                if (end - start + 1 < pos[0] || pos[0] == -1) {
                    pos[0] = end - start + 1;
                    pos[1] = start;
                    pos[2] = end;
                }
                window.put(c, window.get(c) - 1);
                if (window.get(c) < target.get(c))
                    count--;
                l++;
            }
            r++;
        }
        return pos[0] == -1 ? "" : s.substring(pos[1], pos[2] + 1);
    }

}
