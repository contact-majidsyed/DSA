package practice.heaps_intervals_and_greedy.task_scheduler;

import java.util.*;

/** Task Scheduler. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: tasks = [A,A,A,B,B,B], n = 2
    //   Output: 8
    // Example 2:
    //   Input: tasks = [A,A,A,B,B,B], n = 0
    //   Output: 6
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public long leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) return 0;
        int[] count = new int[26];
        // COUNT VISITS A,A,A,B,B,B: A count goes 1,2,3; then B count goes 1,2,3. Other slots stay zero.
        // ===== LOOP START L1: for loop =====
        for (char task : tasks) count[task - 'A']++;
        // ===== LOOP END L1 =====
        int max = 0, tied = 0;
        // MAX SCAN: at slot A max=3; B and all remaining slots leave max=3.
        // ===== LOOP START L2: for loop =====
        for (int c : count) max = Math.max(max, c);
        // ===== LOOP END L2 =====
        // TIE SCAN: A makes tied=1; B makes tied=2; zero slots do not match max=3.
        // ===== LOOP START L3: for loop =====
        for (int c : count) if (c == max) tied++;
        // ===== LOOP END L3 =====
        // AFTER calculation with cooldown n=2: frame=(3-1)*(2+1)+2=8.
        long frame = (long) (max - 1) * ((long) n + 1) + tied;
        // RETURN max(tasks.length=6,frame=8)=8. With cooldown 0, frame=4 and task count wins: 6.
        return Math.max(tasks.length, frame);
    }
}
