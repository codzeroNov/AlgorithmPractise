package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    /*
        Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

        Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

        The order of output does not matter.
    */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, count = map.size();
        while (right < s.length()) {
            char rc = s.charAt(right);

            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc) - 1);
                if (map.get(rc) == 0) {
                    count--;
                }
            }

            while (count == 0) {
                char lc = s.charAt(left);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0)
                        count++;
                }

                if (right - left + 1== p.length())
                    res.add(left);

                left++;
            }

            right++;
        }

        return res;
    }

}
