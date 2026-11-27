package practice.dynamic_programming.climbing_stairs;

import java.util.*;

/** Climbing Stairs. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: n = 4
    //   Output: 5
    // Example 2:
    //   Input: n = 0
    //   Output: 1
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public long climbStairs(int n) {
        if (n < 0 || n > 91) throw new IllegalArgumentException("n must be between 0 and 91");
        // For n=4: START previous=1,current=1, representing ways to reach steps 0 and 1.
        long previous = 1, current = 1;
        // ===== LOOP START L1: for loop =====
        for (int step = 2; step <= n; step++) {
            // At step=2,3,4: next=1+1=2, 1+2=3, 2+3=5.
            long next = previous + current;
            // AFTER assignment at step=2,3,4: previous=1,2,3. next is already saved.
            previous = current;
            // AFTER assignment: (previous,current)=(1,2),(2,3),(3,5). step becomes 5, so 5<=4 is false.
            current = next;
        }
        // ===== LOOP END L1 =====
        // RETURN 5. Example 2 n=0 skips the loop and returns 1 for the empty sequence.
        return current;
    }
}
