package practice.dynamic_programming.longest_increasing_subsequence;

import java.util.*;

/** Longest Increasing Subsequence. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [10,9,2,5,3,7,101,18]
    //   Output: 4
    // Example 2:
    //   Input: nums = [2,2,2]
    //   Output: 1
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        // START size=0; only tails[0..size) is meaningful. The rest are unused zero slots.
        int size = 0;
        // ===== LOOP START L1: for loop =====
        for (int num : nums) {
            // OUTER VISITS num=10,9,2,5,3,7,101,18. Search only the active prefix.
            int left = 0, right = size;
            // ===== LOOP START L2: while loop =====
            while (left < right) {
                // INNER SEARCH for final num=18 with active tails=[2,3,7,101]:
                // (left,right,mid)=(0,4,2):7<18 -> left=3; (3,4,3):101>=18 -> right=3; stop.
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) left = mid + 1;
                else right = mid;
            }
            // ===== LOOP END L2 =====
            // AFTER writes, active tails become [10],[9],[2],[2,5],[2,3],[2,3,7],[2,3,7,101],[2,3,7,18].
            tails[left] = num;
            // size becomes 1,1,1,2,2,3,4,4. Replacing an existing slot does not increase length.
            if (left == size) size++;
        }
        // ===== LOOP END L1 =====
        // RETURN 4. tails summarizes smallest endings; it need not itself be a subsequence.
        return size;
    }
}
