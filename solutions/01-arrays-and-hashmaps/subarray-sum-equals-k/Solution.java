package practice.arrays_and_hashmaps.subarray_sum_equals_k;

import java.util.*;

/** Subarray Sum Equals K. See explanation.md for the contract and walkthrough. */
public class Solution {
    public long subarraySum(int[] nums, int k) {
        Map<Long, Long> counts = new HashMap<>();
        counts.put(0L, 1L);
        long sum = 0, answer = 0;
        for (int num : nums) {
            sum += num;
            answer += counts.getOrDefault(sum - k, 0L);
            counts.put(sum, counts.getOrDefault(sum, 0L) + 1);
        }
        return answer;
    }
}
