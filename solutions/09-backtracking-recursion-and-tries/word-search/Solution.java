package practice.backtracking_recursion_and_tries.word_search;

import java.util.*;

/** Word Search. See explanation.md for the contract and walkthrough. */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return true;
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (find(board, word, r, c, 0, used)) return true;
            }
        }
        return false;
    }
    private boolean find(char[][] board, String word, int r, int c, int index, boolean[][] used) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || used[r][c] || board[r][c] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;
        used[r][c] = true;
        boolean found = find(board, word, r+1, c, index+1, used)
            || find(board, word, r-1, c, index+1, used)
            || find(board, word, r, c+1, index+1, used)
            || find(board, word, r, c-1, index+1, used);
        used[r][c] = false;
        return found;
    }
}
