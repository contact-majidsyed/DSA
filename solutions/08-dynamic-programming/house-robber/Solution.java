package practice.dynamic_programming.house_robber;

import java.util.*;

/** House Robber. See explanation.md for the contract and walkthrough. */
public class Solution {
    public long rob(int[] nums) {
        long twoBack = 0, oneBack = 0;
        for (int value : nums) {
            long current = Math.max(oneBack, twoBack + value);
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
}
