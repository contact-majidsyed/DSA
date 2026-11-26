package practice.heaps_intervals_and_greedy.kth_largest_element;

import java.util.*;

/** Kth Largest Element in an Array. See explanation.md for the contract and walkthrough. */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || k > nums.length) throw new IllegalArgumentException("Invalid k");
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.remove();
        }
        return heap.element();
    }
}
