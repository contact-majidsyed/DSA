package practice.arrays_and_hashmaps.product_of_array_except_self;

import java.util.*;

/** Product of Array Except Self. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [1,2,3,4]
    //   Output: [24,12,8,6]
    // Example 2:
    //   Input: nums = [-1,1,0,-3,3]
    //   Output: [0,0,9,0,0]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int[] productExceptSelf(int[] nums) {
        // START: result=[0,0,0,0], prefix will start at 1.
        int[] result = new int[nums.length];
        int prefix = 1;
        // ===== LOOP START L1: for loop =====
        for (int i = 0; i < nums.length; i++) {
            // FIRST PASS after assignment:
            // i=0 -> [1,0,0,0]; i=1 -> [1,1,0,0]; i=2 -> [1,1,2,0]; i=3 -> [1,1,2,6].
            result[i] = prefix;
            // AFTER this update at i=0,1,2,3: prefix=1,2,6,24. The current element was excluded above.
            prefix *= nums[i];
        }
        // ===== LOOP END L1 =====
        int suffix = 1;
        // ===== LOOP START L2: for loop =====
        for (int i = nums.length - 1; i >= 0; i--) {
            // SECOND PASS after multiplication:
            // i=3 -> [1,1,2,6]; i=2 -> [1,1,8,6]; i=1 -> [1,12,8,6]; i=0 -> [24,12,8,6].
            result[i] *= suffix;
            // AFTER this update at i=3,2,1,0: suffix=4,12,24,24.
            suffix *= nums[i];
        }
        // ===== LOOP END L2 =====
        // RETURN [24,12,8,6].
        return result;
    }
}
