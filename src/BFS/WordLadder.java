package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    /*
        Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
        Only one letter can be changed at a time.
        Each transformed word must exist in the word list.

        Note:
        Return 0 if there is no such transformation sequence.
        All words have the same length.
        All words contain only lowercase alphabetic characters.
        You may assume no duplicates in the word list.
        You may assume beginWord and endWord are non-empty and are not the same.
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList), visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int len = 1;

        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                String w = q.poll();
                if (w.equals(endWord))
                    return len;

                for (int j = 0; j < w.length(); j++) {
                    char[] wa = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == wa[j])
                            continue;
                        wa[j] = c;
                        String nw = String.valueOf(wa);
                        if (dict.contains(nw) && visited.add(nw))
                            q.offer(nw);
                    }
                }
            }
            len++;
        }

        return 0;
    }

    //"The idea behind bidirectional search is to run two simultaneous searches—one forward from
    //the initial state and the other backward from the goal—hoping that the two searches meet in
    //the middle. The motivation is that b^(d/2) + b^(d/2) is much less than b^d. b is branch factor, d is depth. "
    //
    //----- section 3.4.6 in Artificial Intelligence - A modern approach by Stuart Russel and Peter Norvig
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList), visited = new HashSet<>();
        if(!dict.contains(endWord)) return 0;
        HashSet<String> beginSet = new HashSet<>(), endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //swap two queues, we process on the larger one
            if (beginSet.size() > endSet.size()) {
                HashSet<String> swap = beginSet;
                beginSet = endSet;
                endSet = swap;
            }

            HashSet<String> nextRound = new HashSet<>();
            for (String word : beginSet) {
                char[] ca = word.toCharArray();

                for (int j = 0; j < ca.length; j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = ca[j];
                        ca[j] = c;
                        String newWord = String.valueOf(ca);

                        if (endSet.contains(newWord))
                            return len + 1;

                        if (dict.contains(newWord) && visited.add(newWord))
                            nextRound.add(newWord);

                        ca[j] = old;
                    }
                }
            }

            beginSet = nextRound;
            len++;
        }

        return 0;
    }
}
