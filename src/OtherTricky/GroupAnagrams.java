package OtherTricky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    //给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        //当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = new char[26];

            for (char ch : s.toCharArray())
                c[ch - 'a']++;

            String key = String.valueOf(c);
            if (!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

}
