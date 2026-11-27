package practice.heaps_intervals_and_greedy.meeting_rooms_ii;

import java.util.*;

/** Meeting Rooms II. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: intervals = [[9,10],[9,12],[10,11]]
    //   Output: 2
    // Example 2:
    //   Input: intervals = [[1,2],[2,3]]
    //   Output: 1
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int minMeetingRooms(int[][] intervals) {
        // SORT leaves [9,10),[9,12),[10,11) in this order for the example.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        int best = 0;
        // ===== LOOP START L1: for loop =====
        for (int[] interval : intervals) {
            // At start 9: nothing to remove on either visit. At start 10: remove end 10, keep end 12.
            // ===== LOOP START L2: while loop =====
            while (!ends.isEmpty() && ends.peek() <= interval[0]) ends.remove();
            // ===== LOOP END L2 =====
            // AFTER adding each meeting, active end-time sets are {10}, {10,12}, {11,12}.
            ends.add(interval[1]);
            // AFTER visits 1,2,3: best=1,2,2. The freed room is reused for [10,11).
            best = Math.max(best, ends.size());
        }
        // ===== LOOP END L1 =====
        // RETURN 2. Adjacent meetings in Example 2 need only one room.
        return best;
    }
}
