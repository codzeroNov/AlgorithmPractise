package OtherTricky;

import java.util.Arrays;
import java.util.Comparator;

public class HIndex {
    /*
        Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

        According to the definition of h-index on Wikipedia:
        "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
    */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - i - 1] > i)
            i++;
        return i;
    }

    public int hIndex2(int[] citations) {
        int N = citations.length;
        int[] count = new int[N + 1];

        for (int c : citations)
            count[Math.min(N, c)]++;

        int i = N;
        for (int s = count[N]; i > s; s += count[i])
            i--;

        return i;
    }

}
