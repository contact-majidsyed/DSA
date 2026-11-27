package practice.backtracking_recursion_and_tries.combination_sum;

import java.util.*;

/** Combination Sum. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: candidates = [2,3,6,7], target = 7
    //   Output: [[2,2,3],[7]]
    // Example 2:
    //   Input: candidates = [2], target = 3
    //   Output: []
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        // RECURSION ENTRY: remaining=7,start=0,path=[]. Candidates sorted as [2,3,6,7].
        search(candidates, target, 0, new ArrayList<>(), result);
        // FINAL RETURN [[2,2,3],[7]].
        return result;
    }
    private void search(int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> result) {
        // BASE CASE: save [2,2,3] and [7] when remaining reaches 0, then return immediately.
        if (remaining == 0) { result.add(new ArrayList<>(path)); return; }
        // CALL-LOCAL LOOP: root tries 2,3,6,7. Each child starts at the chosen index, allowing reuse.
        // When the next candidate exceeds remaining, this call stops its loop and returns.
        // ===== LOOP START L1: for loop =====
        for (int i = start; i < candidates.length && candidates[i] <= remaining; i++) {
            // CHOOSE / remaining after child starts:
            // []/7 -> [2]/5 -> [2,2]/3 -> [2,2,2]/1 (dead end).
            path.add(candidates[i]);
            // RECURSIVE CALL with i unchanged: after undoing the dead end, choose 3 -> [2,2,3]/0 (save).
            // Other dead branches are [2,3]/2, [3]/4 -> [3,3]/1, and [6]/1. Root [7]/0 is saved.
            search(candidates, remaining - candidates[i], i, path, result);
            // ON RETURN, UNDO the last choice. From saved [2,2,3], path becomes [2,2].
            // Each parent resumes its own loop; result keeps the copied combination.
            path.remove(path.size() - 1);
        }
        // ===== LOOP END L1 =====
    }
}
