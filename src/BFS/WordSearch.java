package BFS;

public class WordSearch {
/*
    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母不允许被重复使用。

    示例:
    board =
            [
            ['A','B','C','E'],
            ['S','F','C','S'],
            ['A','D','E','E']
            ]

    给定 word = "ABCCED", 返回 true
    给定 word = "SEE", 返回 true
    给定 word = "ABCB", 返回 false
             

    提示：
    board 和 word 中只包含大写和小写英文字母。
            1 <= board.length <= 200
            1 <= board[i].length <= 200
            1 <= word.length <= 10^3
    */

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;

        char[] w = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        int wordIdx = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (w[wordIdx] == board[i][j] && bfs(board, i, j, w, wordIdx, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, int i, int j, char[] w, int wi, boolean[][] visited) {
        if (wi == w.length)
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || w[wi] != board[i][j])
            return false;

        visited[i][j] = true;
        if (bfs(board, i + 1, j, w, wi + 1, visited) ||
            bfs(board, i - 1, j, w, wi + 1, visited) ||
            bfs(board, i, j + 1, w, wi + 1, visited) ||
            bfs(board, i, j - 1, w, wi + 1, visited))
            return true;

        visited[i][j] = false;
        return false;
    }

}
