package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class InterleavingString {
    /**
     * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
     * <p>
     * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
     * <p>
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
     * Note: a + b is the concatenation of strings a and b.
     **/

    public boolean isInterleave(String s1, String s2, String s3) {
        /**
         * If we expand the two strings s1 and s2 into a chessboard, then this problem can be transferred into a path seeking problem from the top-left corner to the bottom-right corner.
         * The key is, each cell (y, x) in the board corresponds to an interval between y-th character in s1 and x-th character in s2. And adjacent cells are connected with like a grid.
         * A BFS can then be efficiently performed to find the path.
         **/
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] visited = new boolean[s1.length() + 1][s2.length() + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1];
            if (visited[x][y]) continue;
            if (s1.length() == x && s2.length() == y)
                return true;

            if (x < s1.length() && s1.charAt(x) == s3.charAt(x + y))
                q.offer(new int[]{x + 1, y});
            if (y < s2.length() && s2.charAt(y) == s3.charAt(x + y))
                q.offer(new int[]{x, y + 1});

            visited[x][y] = true;
        }

        return false;
    }
}
