package BitManipulation;

public class MaximumProductOfWordLengths {
    /*
    Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
    You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
    */
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;

        int[] lens = new int[words.length];
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lens[i] = words[i].length();
            int bitmask = 0;
            for (int j = 0; j < words[i].length(); j++) {
                bitmask |= 1 << (words[i].charAt(j) - 'a');
            }
            masks[i] = bitmask;
        }

        int max = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if ((masks[i] & masks[j]) == 0)
                    max = Math.max(max, lens[i] * lens[j]);

        return max;
    }
}
