package practice.heaps_intervals_and_greedy.meeting_rooms_ii;

import java.util.*;

/** Meeting Rooms II. See explanation.md for the contract and walkthrough. */
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        int best = 0;
        for (int[] interval : intervals) {
            while (!ends.isEmpty() && ends.peek() <= interval[0]) ends.remove();
            ends.add(interval[1]);
            best = Math.max(best, ends.size());
        }
        return best;
    }
}
