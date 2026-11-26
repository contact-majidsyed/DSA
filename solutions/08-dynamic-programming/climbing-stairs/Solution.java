package practice.dynamic_programming.climbing_stairs;

import java.util.*;

/** Climbing Stairs. See explanation.md for the contract and walkthrough. */
public class Solution {
    public long climbStairs(int n) {
        if (n < 0 || n > 91) throw new IllegalArgumentException("n must be between 0 and 91");
        long previous = 1, current = 1;
        for (int step = 2; step <= n; step++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}
