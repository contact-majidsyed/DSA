package practice.two_pointers_and_binary_search.three_sum;

import java.util.*;

/** 3Sum. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [-1,0,1,2,-1,-4]
    //   Output: [[-1,-1,2],[-1,0,1]]
    // Example 2:
    //   Input: nums = [0,0,0,0]
    //   Output: [[0,0,0]]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public List<List<Integer>> threeSum(int[] nums) {
        // AFTER sorting: nums=[-4,-1,-1,0,1,2]. This changes the input order.
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // ===== LOOP START L1: for loop =====
        for (int i = 0; i < nums.length - 2; i++) {
            // OUTER VISITS: i=0,1,2,3; i=2 is skipped because nums[2]==nums[1].
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            // ===== LOOP START L2: while loop =====
            while (left < right) {
                // i=0 (-4): (left,right)=(1,5),(2,5),(3,5),(4,5) -> sums -3,-3,-2,-1.
                // i=1 (-1): (2,5)->0, then (3,4)->0. i=3 (0): (4,5)->3, then pointers meet.
                long sum = (long) nums[i] + nums[left] + nums[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    // After the two matches at i=1: result=[[-1,-1,2],[-1,0,1]].
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int a = nums[left], b = nums[right];
                    // After a match, skip equal left values; do not emit the same triplet again.
                    // ===== LOOP START L3: while loop =====
                    while (left < right && nums[left] == a) left++;
                    // ===== LOOP END L3 =====
                    // Then skip equal right values. After the second match, left==right -> finish this pair search.
                    // ===== LOOP START L4: while loop =====
                    while (left < right && nums[right] == b) right--;
                    // ===== LOOP END L4 =====
                }
            }
            // ===== LOOP END L2 =====
        }
        // ===== LOOP END L1 =====
        // RETURN the two unique triplets.
        return result;
    }
}
