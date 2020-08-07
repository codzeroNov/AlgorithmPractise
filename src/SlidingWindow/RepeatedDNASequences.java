package SlidingWindow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RepeatedDNASequences {
    /*
        All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
        When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
        Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
    */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0)
            return new LinkedList<>();

        HashSet<String> visited = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (!visited.add(str))
                repeated.add(str);
        }

        return new LinkedList<>(repeated);
    }
}
