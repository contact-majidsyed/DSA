package practice.two_pointers_and_binary_search.search_rotated_sorted_array;

import java.util.*;

/** Search in Rotated Sorted Array. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [4,5,6,7,0,1,2], target = 0
    //   Output: 4
    // Example 2:
    //   Input: nums = [4,5,6,7,0,1,2], target = 3
    //   Output: -1
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // ===== LOOP START L1: while loop =====
        while (left <= right) {
            // For target=0, visits (left,right,mid,value):
            // (0,6,3,7) -> (4,6,5,1) -> (4,4,4,0).
            int mid = left + (right - left) / 2;
            // EARLY RETURN on the third visit: nums[4]=0, so return index 4.
            if (nums[mid] == target) return mid;
            // Visit 1: left half [4,5,6,7] is sorted but excludes target -> left=4.
            // Visit 2: left half [0,1] includes target -> right=4.
            if (nums[left] <= nums[mid]) {
                // Visit 1: left half [4,5,6,7] is sorted but excludes target -> left=4.
                // Visit 2: left half [0,1] includes target -> right=4.
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        // ===== LOOP END L1 =====
        // Only reached if bounds cross without a match. Example 2 (target=3) returns -1.
        return -1;
    }
}
