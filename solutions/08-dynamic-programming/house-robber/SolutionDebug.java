package practice.dynamic_programming.house_robber;

import java.util.*;

/** House Robber. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [2,7,9,3,1]
    //   Output: 12
    // Example 2:
    //   Input: nums = [2,1,1,2]
    //   Output: 4
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public long rob(int[] nums) {
        // START twoBack=0,oneBack=0.
        long twoBack = 0, oneBack = 0;
        // ===== LOOP START L1: for loop =====
        for (int value : nums) {
            // Visits value=2,7,9,3,1:
            // max(skip,take)=max(0,2)=2; max(2,7)=7; max(7,11)=11; max(11,10)=11; max(11,12)=12.
            long current = Math.max(oneBack, twoBack + value);
            // AFTER shifting twoBack: 0,2,7,11,11 across the five visits.
            twoBack = oneBack;
            // AFTER each full visit (twoBack,oneBack): (0,2),(2,7),(7,11),(11,11),(11,12).
            oneBack = current;
        }
        // ===== LOOP END L1 =====
        // RETURN 12, achieved by 2+9+1. Example 2 returns 4 from the first and last houses.
        return oneBack;
    }
}
