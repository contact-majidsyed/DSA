package practice.backtracking_recursion_and_tries.subsets;

import java.util.*;

/** Subsets. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [1,2]
    //   Output: [[],[1],[2],[1,2]]
    // Example 2:
    //   Input: nums = []
    //   Output: [[]]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // RECURSION ENTRY: start=0,path=[],result=[].
        collect(nums, 0, new ArrayList<>(), result);
        // FINAL RETURN [[],[1],[1,2],[2]]. Question ordering may differ.
        return result;
    }
    private void collect(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        // SAVE ON ENTRY: copies are added in order [],[1],[1,2],[2].
        // Copy the list because the working path will be changed after returning.
        result.add(new ArrayList<>(path));
        // CALL-LOCAL LOOP: root call tries i=0 then i=1. The call with path=[1] tries only i=1.
        // BASE CASE is no remaining indices: start==nums.length -> skip loop and return.
        // ===== LOOP START L1: for loop =====
        for (int i = start; i < nums.length; i++) {
            // CHOOSE: root i=0 -> path=[1]; child i=1 -> path=[1,2].
            path.add(nums[i]);
            // RECURSIVE CALL: pass the next index; a child call has its own start and i.
            collect(nums, i + 1, path, result);
            // ON RETURN, UNDO: [1,2]->[1], then [1]->[]. Root next chooses [2], then undoes it to [].
            path.remove(path.size() - 1);
        }
        // ===== LOOP END L1 =====
    }
}
