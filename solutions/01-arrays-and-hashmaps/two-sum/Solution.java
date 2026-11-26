package practice.arrays_and_hashmaps.two_sum;

import java.util.*;

/** Two Sum. See explanation.md for the contract and walkthrough. */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long need = (long) target - nums[i];
            if (need >= Integer.MIN_VALUE && need <= Integer.MAX_VALUE && seen.containsKey((int) need)) {
                return new int[]{seen.get((int) need), i};
            }
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No pair found");
    }
}
