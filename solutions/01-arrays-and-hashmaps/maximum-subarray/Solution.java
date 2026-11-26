package practice.arrays_and_hashmaps.maximum_subarray;

import java.util.*;

/** Maximum Subarray. See explanation.md for the contract and walkthrough. */
public class Solution {
    public long maxSubArray(int[] nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Empty input");
        long current = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }
}
