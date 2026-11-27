package practice.heaps_intervals_and_greedy.top_k_frequent_elements;

import java.util.*;

/** Top K Frequent Elements. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [1,1,1,2,2,3], k = 2
    //   Output: [1,2]
    // Example 2:
    //   Input: nums = [4,4,4], k = 1
    //   Output: [4]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        // COUNT VISITS 1,1,1,2,2,3 -> map updates 1:1,1:2,1:3,2:1,2:2,3:1.
        // ===== LOOP START L1: for loop =====
        for (int num : nums) count.merge(num, 1, Integer::sum);
        // ===== LOOP END L1 =====
        if (k < 0 || k > count.size()) throw new IllegalArgumentException("Invalid k");
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));
        // KEY VISIT order is unspecified. One possible order is 1,2,3; comments below illustrate that order.
        // ===== LOOP START L2: for loop =====
        for (int num : count.keySet()) {
            heap.add(num);
            // For key order 1,2,3 and k=2: retained sets are {1}, {1,2}, {1,2}; inserting 3 evicts 3.
            // Heap comparator uses frequency, not numeric value.
            if (heap.size() > k) heap.remove();
        }
        // ===== LOOP END L2 =====
        int[] result = new int[k];
        // OUTPUT VISITS: pop 2 (frequency2), then 1 (frequency3) -> result=[2,1].
        // Question output [1,2] is also valid: output order does not matter.
        // ===== LOOP START L3: for loop =====
        for (int i = 0; i < k; i++) result[i] = heap.remove();
        // ===== LOOP END L3 =====
        // RETURN the two most frequent values.
        return result;
    }
}
