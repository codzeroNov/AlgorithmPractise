package OtherTricky;

import java.util.HashSet;

public class ValidSudoku {

/*
    Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*/

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char num = board[i][j];
                if (num == '.')
                    continue;
                if (!set.add(num + " in row " + i)
                        || !set.add(num + " in col " + j)
                        || !set.add(num + " in subbox " + i/3 + j/3))
                    return false;
            }
        }
        return true;
    }
}
