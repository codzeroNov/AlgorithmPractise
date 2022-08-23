package DP.OnString;

import java.util.*;

public class ConcatenatedWords {
    /**
     * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
     *
     * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
     * **/
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));

        Set<String> prevWords = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], prevWords))
                res.add(words[i]);
            prevWords.add(words[i]);
        }

        return res;
    }

    private boolean canForm(String word, Set<String> prevWords) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && prevWords.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[word.length()];
    }
}
