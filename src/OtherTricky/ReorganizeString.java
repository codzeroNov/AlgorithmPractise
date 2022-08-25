package OtherTricky;

import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {
    /**
     * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
     *
     * Return any possible rearrangement of s or return "" if not possible.
     * **/

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        char maxChar = '#';
        for (char c : s.toCharArray()) {
            int cnt = map.getOrDefault(c, 0);
            if (cnt + 1 > max){
                max = cnt + 1;
                maxChar = c;
            }
            map.put(c, cnt + 1);
        }

        if (max > (s.length() + 1) / 2)
            return "";

        char[] res = new char[s.length()];
        int idx = 0;
        while (max > 0) {
            res[idx] = maxChar;
            max--;
            idx += 2;
        }
        map.remove(maxChar);

        for (char c : map.keySet()) {
            int cnt = map.get(c);
            while (cnt > 0) {
                if (idx >= res.length)
                    idx = 1;
                res[idx] = c;
                idx += 2;
                cnt--;
            }
        }

        return String.valueOf(res);
    }
}
