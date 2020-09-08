package Greedy;

import java.util.*;

public class RemoveDuplicateLetters {
    /*
        Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once.
        You must make sure your result is the smallest in lexicographical order among all possible results.
    */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0)
            return "";

        int[] cnt = new int[26];
        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0)
                break;
        }

        String str = s.substring(pos + 1).replaceAll("" + s.charAt(pos), "");

        return s.charAt(pos) + removeDuplicateLetters(str);
    }

    public String removeDuplicateLetters2(String s) {
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> last_occurrence = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) last_occurrence.put(s.charAt(i), i);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && i < last_occurrence.get(stack.peek())) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }

}
