package SlidingWindow;

import java.util.*;

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

    public List<Integer> partitionLabels2(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new int[]{i, Integer.MIN_VALUE});
            } else {
                int[] arr = map.get(c);
                arr[1] = i;
                map.put(c, arr);
            }
        }

        int[][] intervals = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            intervals[i++] = arr;
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int prevEnd = intervals[0][1], prevStart = intervals[0][0];
        for (i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > prevEnd) {
                if (prevEnd == Integer.MIN_VALUE)
                    res.add(1);
                else
                    res.add(prevEnd - prevStart + 1);
                prevEnd = intervals[i][1];
                prevStart = intervals[i][0];
            } else {
                prevEnd = Math.max(prevEnd, intervals[i][1]);
            }
        }
        if (prevEnd == Integer.MIN_VALUE)
            res.add(1);
        else
            res.add(prevEnd - prevStart + 1);

        return res;
    }

    public static void main(String[] args) {
        new PartitionLabels().partitionLabels2("eaaaabaaec");
    }

}
