package practice.backtracking_recursion_and_tries.permutations;

import java.util.*;

/** Permutations. See explanation.md for the contract and walkthrough. */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        build(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }
    private void build(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) { result.add(new ArrayList<>(path)); return; }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            build(nums, used, path, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
