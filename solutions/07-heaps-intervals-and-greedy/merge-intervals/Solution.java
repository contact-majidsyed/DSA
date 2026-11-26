package practice.heaps_intervals_and_greedy.merge_intervals;

import java.util.*;

/** Merge Intervals. See explanation.md for the contract and walkthrough. */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval.clone());
            } else {
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
