package practice.two_pointers_and_binary_search.three_sum;

import java.util.*;

/** 3Sum. See explanation.md for the contract and walkthrough. */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int a = nums[left], b = nums[right];
                    while (left < right && nums[left] == a) left++;
                    while (left < right && nums[right] == b) right--;
                }
            }
        }
        return result;
    }
}
