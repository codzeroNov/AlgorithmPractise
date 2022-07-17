package Greedy;

import java.util.HashSet;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    /**
     * A string s is called good if there are no two different characters in s that have the same frequency.
     *
     * Given a string s, return the minimum number of characters you need to delete to make s good.
     *
     * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
     * **/

    public int minDeletions(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray())
            arr[c - 'a']++;

        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0 && !set.add(arr[i])) {
                arr[i]--;
                res++;
            }
        }

        return res++;
    }
}
