package practice.backtracking_recursion_and_tries.word_search;

import java.util.*;

/** Word Search. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: board = ["ABCE","SFCS","ADEE"], word = "ABCCED"
    //   Output: true
    // Example 2:
    //   Input: board = ["ABCE","SFCS","ADEE"], word = "ABCB"
    //   Output: false
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return true;
        if (board.length == 0 || board[0].length == 0) return false;
        // START 3x4 false grid. board is unchanged; used records only the current search path.
        boolean[][] used = new boolean[board.length][board[0].length];
        // ===== LOOP START L1: for loop =====
        for (int r = 0; r < board.length; r++) {
            // ===== LOOP START L2: for loop =====
            for (int c = 0; c < board[0].length; c++) {
                // GRID SCAN: first start (0,0) succeeds for ABCCED -> EARLY RETURN true, so later starts are not tried.
                if (find(board, word, r, c, 0, used)) return true;
            }
            // ===== LOOP END L2 =====
        }
        // ===== LOOP END L1 =====
        return false;
    }
    // START 3x4 false grid. board is unchanged; used records only the current search path.
    // RECURSION START for each attempted position: index identifies the next required character.
    // Successful path: (0,0)/A -> (0,1)/B -> (0,2)/C -> (1,2)/C -> (2,2)/E -> (2,1)/D.
    private boolean find(char[][] board, String word, int r, int c, int index, boolean[][] used) {
        // FAILURE BASE CASE: out of bounds, already used, or wrong letter -> return false to try another direction.
        // At (0,0), down (1,0)=S fails and up (-1,0) fails before right (0,1)=B succeeds.
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || used[r][c] || board[r][c] != word.charAt(index)) return false;
        // SUCCESS BASE CASE: at (2,1), index=5, D matches -> return true without marking this final cell.
        if (index == word.length() - 1) return true;
        // MARK before recursion: the first five successful path cells become true as the call stack grows.
        used[r][c] = true;
        // RECURSIVE CALLS try down, up, right, left. || stops trying directions after the first true result.
        boolean found = find(board, word, r+1, c, index+1, used)
            || find(board, word, r-1, c, index+1, used)
            || find(board, word, r, c+1, index+1, used)
            || find(board, word, r, c-1, index+1, used);
        // ON RETURN, RESTORE each marked cell even on success. After unwinding to the caller, used is all false.
        used[r][c] = false;
        // RETURN true along the successful call chain. Example 2 ABCB exhausts possibilities -> false.
        return found;
    }
}
