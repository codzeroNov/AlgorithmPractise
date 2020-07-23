package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
/*
    A string S of lowercase English letters is given.
    We want to partition this string into as many parts as possible so that each letter appears in at most one part,
    and return a list of integers representing the size of these parts.

    Example 1:
    Input: S = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

    Note:
    S will have length in range [1, 500].
    S will consist of lowercase English letters ('a' to 'z') only.
*/

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> lastPos = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            lastPos.put(S.charAt(i), i);
        }

        int pos = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            pos = Math.max(pos, lastPos.get(S.charAt(i)));
            if (pos == i) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }

        return list;
    }

}
