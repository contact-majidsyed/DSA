package practice.backtracking_recursion_and_tries.permutations;

import java.util.*;

/** Permutations. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: nums = [1,2,3]
    //   Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    // Example 2:
    //   Input: nums = []
    //   Output: [[]]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // RECURSION ENTRY: used=[false,false,false],path=[],result=[].
        build(nums, new boolean[nums.length], new ArrayList<>(), result);
        // FINAL RETURN six permutations; the working path is empty again.
        return result;
    }
    private void build(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        // BASE CASE: save each full-length copy, then return.
        // Saved order: [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1].
        if (path.size() == nums.length) { result.add(new ArrayList<>(path)); return; }
        // ===== LOOP START L1: for loop =====
        for (int i = 0; i < nums.length; i++) {
            // CALL-LOCAL LOOP: each call tries indices 0,1,2; already-used indices skip the rest of that visit.
            if (used[i]) continue;
            // CHOOSE along first branch: used=[T,F,F] -> [T,T,F] -> [T,T,T]. T/F abbreviate true/false.
            used[i] = true;
            // AFTER append along first branch: path=[1] -> [1,2] -> [1,2,3].
            path.add(nums[i]);
            // RECURSIVE CALL shares path/used, but has its own loop index. Return here before undoing.
            build(nums, used, path, result);
            // UNDO PATH: after first saved permutation, [1,2,3]->[1,2], then the parent later restores [1].
            path.remove(path.size() - 1);
            // UNDO FLAG too: release index 2, then index 1. With path=[1], the next choice is 3 -> branch [1,3,2].
            used[i] = false;
        }
        // ===== LOOP END L1 =====
    }
}
