package UnionFind;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarityII {
    /**
     * Given two sentences words1, words2(each represented as an array of strings), and a list of similar word pairs, determine if two sentences are similar.
     * <p>
     * For example,words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"]are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
     * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
     * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
     * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = []are similar, even though there are no specified similar word pairs.
     * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
     **/


    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;

        UnionFind uf = new UnionFind(2 * words1.length);
        int id = 0;
        Map<String, Integer> wordToIndex = new HashMap<>();
        for (String[] pair : pairs) {
            for (String word : pair) {
                if (!wordToIndex.containsKey(word))
                    wordToIndex.put(word, id++);
            }
            uf.union(wordToIndex.get(pair[0]), wordToIndex.get(pair[1]));
        }

        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i], w2 = words2[i];

            if (w1.equals(w2))
                continue;
            if (!wordToIndex.containsKey(w1) || !wordToIndex.containsKey(w2) || uf.find(wordToIndex.get(w1)) != uf.find(wordToIndex.get(w2)))
                return false;
        }

        return true;

    }

    class UnionFind {
        int[] parents;
        int size;

        public UnionFind(int size) {
            this.size = size;
            this.parents = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = i;
            }
        }

        private int find(int target) {
            while (target != parents[target])
                target = parents[target];
            return target;
        }

        private void union(int from, int to) {
            parents[find(from)] = parents[find(to)];
        }
    }

}
