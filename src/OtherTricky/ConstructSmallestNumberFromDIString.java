package OtherTricky;

public class ConstructSmallestNumberFromDIString {
    /**
     * You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.
     *
     * A 0-indexed string num of length n + 1 is created using the following conditions:
     *
     * num consists of the digits '1' to '9', where each digit is used at most once.
     * If pattern[i] == 'I', then num[i] < num[i + 1].
     * If pattern[i] == 'D', then num[i] > num[i + 1].
     * Return the lexicographically smallest possible string num that meets the conditions.
     * **/

    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();
        for (int i = 0; i <= pattern.length(); i++) {
            stack.append((char)('1' + i));
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }

        return res.toString();
    }
}
