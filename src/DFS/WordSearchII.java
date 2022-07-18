package DFS;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    /**
     * Given an m x n board of characters and a list of strings words, return all words on the board.
     * <p>
     * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
     **/


    class TrieNode {
        TrieNode[] next;
        String word;

        TrieNode() {
            this.next = new TrieNode[26];
        }
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                if (node.next[c - 'a'] == null)
                    node.next[c - 'a'] = new TrieNode();
                node = node.next[c - 'a'];
            }
            node.word = w;
        }
        return root;
    }

    int m, n;

    public List<String> findWords(char[][] board, String[] words) {
        // dfs + trie
        List<String> res = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        TrieNode root = buildTrie(words);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#')
            return;

        char c = board[i][j];
        node = node.next[c - 'a'];
        if (node == null)
            return;

        if (node.word != null) {
            res.add(node.word);
            node.word = null; // de-duplicate
        }

        board[i][j] = '#';
        dfs(board, i + 1, j, node, res);
        dfs(board, i - 1, j, node, res);
        dfs(board, i, j + 1, node, res);
        dfs(board, i, j - 1, node, res);
        board[i][j] = c;
    }

}
