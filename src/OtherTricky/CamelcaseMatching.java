package OtherTricky;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    /**
     * Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
     *
     * A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.
     * **/

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>(queries.length);

        for (String query : queries) {
            res.add(match(query, pattern));
        }

        return res;
    }

    private boolean match(String query, String pattern) {
        int j = 0;
        for (int i = 0; i < query.length(); i++) {
            if (j < pattern.length() && query.charAt(i) == pattern.charAt(j))
                j++;
            else if (query.charAt(i) >= 'A' && query.charAt(i) <= 'Z')
                return false;
        }
        return j == pattern.length();
    }
}
