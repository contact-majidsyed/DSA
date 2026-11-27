package practice.two_pointers_and_binary_search.container_with_most_water;

import java.util.*;

/** Container With Most Water. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: height = [1,8,6,2,5,4,8,3,7]
    //   Output: 49
    // Example 2:
    //   Input: height = [1,1]
    //   Output: 1
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public long maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        // START left=0,right=8,best=0.
        long best = 0;
        // ===== LOOP START L1: while loop =====
        while (left < right) {
            // Visits (left,right) -> area -> best:
            // (0,8)->8->8; (1,8)->49->49; (1,7)->18->49; (1,6)->40->49;
            // (2,6)->24->49; (3,6)->6->49; (4,6)->10->49; (5,6)->4->49.
            best = Math.max(best, (long) Math.min(height[left], height[right]) * (right - left));
            // Move the shorter endpoint. At (1,6), both heights are 8: this code moves left.
            // After (5,6), left becomes 6 -> left < right is false.
            if (height[left] <= height[right]) left++;
            else right--;
        }
        // ===== LOOP END L1 =====
        // RETURN 49 from indices 1 and 8.
        return best;
    }
}
