package practice.arrays_and_hashmaps.two_sum;

import java.util.*;

/** Two Sum. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [2,7,11,15], target = 9
    //   Output: [0,1]
    // Example 2:
    //   Input: nums = [3,3], target = 6
    //   Output: [0,1]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int[] twoSum(int[] nums, int target) {
        // START: seen={} holds value -> earlier index.
        Map<Integer, Integer> seen = new HashMap<>();
        // ===== LOOP START L1: for loop =====
        for (int i = 0; i < nums.length; i++) {
            // Visits: i=0, value=2 -> need=7; i=1, value=7 -> need=2.
            // The long subtraction avoids overflowing an int complement.
            long need = (long) target - nums[i];
            if (need >= Integer.MIN_VALUE && need <= Integer.MAX_VALUE && seen.containsKey((int) need)) {
                // EARLY RETURN at i=1: seen.get(2)=0 -> return [0,1].
                // The loop ends immediately; indices 2 and 3 are never visited.
                return new int[]{seen.get((int) need), i};
            }
            // After i=0: seen={2:0}. Lookup happened first, so index 0 cannot pair with itself.
            seen.put(nums[i], i);
        }
        // ===== LOOP END L1 =====
        throw new IllegalArgumentException("No pair found");
    }
}
