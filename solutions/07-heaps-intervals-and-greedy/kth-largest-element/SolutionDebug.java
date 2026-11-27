package practice.heaps_intervals_and_greedy.kth_largest_element;

import java.util.*;

/** Kth Largest Element in an Array. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [3,2,1,5,6,4], k = 2
    //   Output: 5
    // Example 2:
    //   Input: nums = [2,2,1], k = 2
    //   Output: 2
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || k > nums.length) throw new IllegalArgumentException("Invalid k");
        // START empty heap, k=2. Displays below are sorted retained VALUES, not the heap backing-array order.
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // ===== LOOP START L1: for loop =====
        for (int num : nums) {
            // Visit num=3,2,1,5,6,4. Add the new value before checking size.
            heap.add(num);
            // AFTER trimming each visit: [3], [2,3], [2,3], [3,5], [5,6], [5,6].
            // Removed values on visits 3..6: 1,2,3,4.
            if (heap.size() > k) heap.remove();
        }
        // ===== LOOP END L1 =====
        // RETURN smallest retained value=5. Example 2 retains [2,2], returning 2.
        return heap.element();
    }
}
