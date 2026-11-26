package practice.backtracking_recursion_and_tries.combination_sum;

import java.util.*;

/** Combination Sum. See explanation.md for the contract and walkthrough. */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        search(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void search(int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) { result.add(new ArrayList<>(path)); return; }
        for (int i = start; i < candidates.length && candidates[i] <= remaining; i++) {
            path.add(candidates[i]);
            search(candidates, remaining - candidates[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }
}
