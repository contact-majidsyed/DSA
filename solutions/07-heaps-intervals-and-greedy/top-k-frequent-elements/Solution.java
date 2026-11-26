package practice.heaps_intervals_and_greedy.top_k_frequent_elements;

import java.util.*;

/** Top K Frequent Elements. See explanation.md for the contract and walkthrough. */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.merge(num, 1, Integer::sum);
        if (k < 0 || k > count.size()) throw new IllegalArgumentException("Invalid k");
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (int num : count.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.remove();
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = heap.remove();
        return result;
    }
}
