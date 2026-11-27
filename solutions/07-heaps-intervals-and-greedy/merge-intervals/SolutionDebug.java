package practice.heaps_intervals_and_greedy.merge_intervals;

import java.util.*;

/** Merge Intervals. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: intervals = [[1,3],[2,6],[8,10]]
    //   Output: [[1,6],[8,10]]
    // Example 2:
    //   Input: intervals = [[1,4],[4,5]]
    //   Output: [[1,5]]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int[][] merge(int[][] intervals) {
        // AFTER sort: [[1,3],[2,6],[8,10]], already in start order.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        // ===== LOOP START L1: for loop =====
        for (int[] interval : intervals) {
            // VISIT [1,3]: result empty -> append a copy. VISIT [2,6]: overlaps -> extend.
            // VISIT [8,10]: previous end=6 < start=8 -> append a new group.
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval.clone());
            } else {
                int[] last = result.get(result.size() - 1);
                // At [2,6]: last=[1,3] -> update last[1]=max(3,6)=6 -> last=[1,6].
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        // ===== LOOP END L1 =====
        // RETURN [[1,6],[8,10]]. Example 2 touches at 4, so [1,4] and [4,5] merge to [1,5].
        return result.toArray(new int[result.size()][]);
    }
}
