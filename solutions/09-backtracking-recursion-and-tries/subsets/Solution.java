package practice.backtracking_recursion_and_tries.subsets;

import java.util.*;

/** Subsets. See explanation.md for the contract and walkthrough. */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        collect(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void collect(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            collect(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
