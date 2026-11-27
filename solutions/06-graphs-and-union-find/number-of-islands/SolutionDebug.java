package practice.graphs_and_union_find.number_of_islands;

import java.util.*;

/** Number of Islands. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: grid = ["1100","1001","0011"]
    //   Output: 2
    // Example 2:
    //   Input: grid = ["10","01"]
    //   Output: 2
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        // START rows=3,cols=4,islands=0. Rows and columns are zero-based.
        int rows = grid.length, cols = grid[0].length, islands = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> stack = new ArrayDeque<>();
        // ===== LOOP START L1: for loop =====
        for (int r = 0; r < rows; r++) {
            // ===== LOOP START L2: for loop =====
            for (int c = 0; c < cols; c++) {
                // SCAN visits all cells row by row. Flooded land is changed to 0, so later scan visits skip it.
                if (grid[r][c] != '1') continue;
                // Only (r,c)=(0,0) and (1,3) start floods: islands becomes 1, then 2.
                islands++;
                grid[r][c] = '0';
                stack.push(new int[]{r,c});
                // ===== LOOP START L3: while loop =====
                while (!stack.isEmpty()) {
                    // FLOOD pop order with this direction order and LIFO stack:
                    // first island: (0,0),(0,1),(1,0); second: (1,3),(2,3),(2,2).
                    int[] cell = stack.pop();
                    // ===== LOOP START L4: for loop =====
                    for (int[] d : directions) {
                        // NEIGHBOR VISITS try down, up, right, left. For (0,0): (1,0),(-1,0),(0,1),(0,-1).
                        int nr = cell[0] + d[0], nc = cell[1] + d[1];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                            // Mark BEFORE pushing: from (0,0), mark (1,0) and (0,1).
                            // Neither can be pushed again by a different neighbor.
                            grid[nr][nc] = '0';
                            stack.push(new int[]{nr,nc});
                        }
                    }
                    // ===== LOOP END L4 =====
                }
                // ===== LOOP END L3 =====
            }
            // ===== LOOP END L2 =====
        }
        // ===== LOOP END L1 =====
        // RETURN 2; all original land has been changed to water in the input grid.
        return islands;
    }
}
