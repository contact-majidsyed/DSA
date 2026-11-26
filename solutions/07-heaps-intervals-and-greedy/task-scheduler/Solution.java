package practice.heaps_intervals_and_greedy.task_scheduler;

import java.util.*;

/** Task Scheduler. See explanation.md for the contract and walkthrough. */
public class Solution {
    public long leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) return 0;
        int[] count = new int[26];
        for (char task : tasks) count[task - 'A']++;
        int max = 0, tied = 0;
        for (int c : count) max = Math.max(max, c);
        for (int c : count) if (c == max) tied++;
        long frame = (long) (max - 1) * ((long) n + 1) + tied;
        return Math.max(tasks.length, frame);
    }
}
