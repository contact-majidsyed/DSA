package practice.two_pointers_and_binary_search.container_with_most_water;

import java.util.*;

/** Container With Most Water. See explanation.md for the contract and walkthrough. */
public class Solution {
    public long maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        long best = 0;
        while (left < right) {
            best = Math.max(best, (long) Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return best;
    }
}
