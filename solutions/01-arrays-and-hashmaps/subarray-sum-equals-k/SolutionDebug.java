package practice.arrays_and_hashmaps.subarray_sum_equals_k;

import java.util.*;

/** Subarray Sum Equals K. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [1,2,3], k = 3
    //   Output: 2
    // Example 2:
    //   Input: nums = [0,0,0], k = 0
    //   Output: 6
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public long subarraySum(int[] nums, int k) {
        Map<Long, Long> counts = new HashMap<>();
        // SEED counts={0:1}: one empty prefix exists before the array.
        counts.put(0L, 1L);
        long sum = 0, answer = 0;
        // ===== LOOP START L1: for loop =====
        for (int num : nums) {
            // Visits num=1,2,3 -> sum becomes 1,3,6.
            sum += num;
            // At sums 1,3,6: look up sum-k = -2,0,3 -> counts 0,1,1.
            // AFTER this line: answer=0,1,2 respectively.
            answer += counts.getOrDefault(sum - k, 0L);
            // AFTER each visit: {0:1,1:1}, then add 3:1, then add 6:1.
            // Record AFTER querying so a prefix does not pair with itself.
            counts.put(sum, counts.getOrDefault(sum, 0L) + 1);
        }
        // ===== LOOP END L1 =====
        // RETURN 2: subarrays [1,2] and [3].
        return answer;
    }
}
