package practice.arrays_and_hashmaps.maximum_subarray;

import java.util.Arrays;

/**
 * Read the comments for a fixed walkthrough, or run main to print each update.
 * Both inputs and expected outputs come from question.md.
 * The calculation is the same as Solution.java; extra variables expose the choices.
 */
public class SolutionDebug {
    public long maxSubArray(int[] nums) {
        // Example 1: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]. Expected return: 6.
        // Example 2: nums = [-5, -2, -7]. Expected return: -2.
        // nums is never changed. Comments below trace Example 1.
        if (nums.length == 0) {
            // Example 1: length = 9, so this branch is skipped.
            throw new IllegalArgumentException("Empty input");
        }

        long current = nums[0];
        // current = -2: best sum of a nonempty stretch ending at index 0.
        System.out.printf("current = nums[0] -> current=%d%n", current);

        long best = nums[0];
        // best = -2: largest sum found anywhere so far.
        System.out.printf("best = nums[0]    -> best=%d%n", best);

        for (int i = 1; i < nums.length; i++) {
            // i visits 1, 2, 3, 4, 5, 6, 7, 8. At i=9, 9<9 is false: stop.
            // nums[i]: 1, -3, 4, -1, 2, 1, -5, 4 respectively.
            System.out.printf("%nLOOP: i=%d, i < %d is true, nums[i]=%d%n",
                    i, nums.length, nums[i]);

            long restart = nums[i];
            // Take just this number. Values after this line:
            // i:       1   2   3   4   5   6   7   8
            // restart: 1  -3   4  -1   2   1  -5   4
            System.out.printf("restart = nums[i] -> restart=%d%n", restart);

            long extend = current + nums[i];
            // This uses OLD current, before the update below.
            // i=1: -2 +  1 = -1       i=5:  3 +  2 = 5
            // i=2:  1 + -3 = -2       i=6:  5 +  1 = 6
            // i=3: -2 +  4 =  2       i=7:  6 + -5 = 1
            // i=4:  4 + -1 =  3       i=8:  1 +  4 = 5
            System.out.printf("extend = current + nums[i] -> %d + (%d) = %d%n",
                    current, nums[i], extend);

            // Print the operands BEFORE replacing current.
            System.out.printf("current = Math.max(restart, extend) -> max(%d, %d)%n",
                    restart, extend);
            current = Math.max(restart, extend);
            // Values AFTER this assignment:
            // i:       1   2   3   4   5   6   7   8
            // current: 1  -2   4   3   5   6   1   5
            // Restart at i=1 and i=3. Extend at every other visited index.
            System.out.printf("  stored current=%d%n", current);

            // Print old best and NEW current before updating best.
            System.out.printf("best = Math.max(best, current) -> max(%d, %d)%n",
                    best, current);
            best = Math.max(best, current);
            // Values AFTER this assignment:
            // i:       1   2   3   4   5   6   7   8
            // best:    1   1   4   4   5   6   6   6
            // At i=7, current falls to 1, but best keeps the earlier record of 6.
            System.out.printf("  stored best=%d%n", best);
        }

        // Example 1: current=5, best=6. Return best, not current.
        // Example 2: current=-7, best=-2. Return -2, not zero.
        // The loop-local i, restart, and extend are now out of scope.
        System.out.printf("%nLOOP FINISHED: current=%d, best=%d%n", current, best);
        System.out.printf("return best -> %d%n", best);
        return best;
    }

    public static void main(String[] args) {
        SolutionDebug debug = new SolutionDebug();
        // debug now refers to the object whose method prints the trace.

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // nums holds question.md's first example input.
        long expected = 6;
        // expected is only for checking the result; the algorithm never uses it.
        System.out.println("EXAMPLE 1: " + Arrays.toString(nums));
        long actual = debug.maxSubArray(nums);
        // The method has finished: actual=6, expected=6; nums is unchanged.
        System.out.printf("Expected=%d, actual=%d%n", expected, actual);
        if (actual != expected) throw new AssertionError("Example 1 failed");

        nums = new int[]{-5, -2, -7};
        // nums now refers to question.md's second example input.
        expected = -2;
        // All-negative input: the answer must still contain at least one number.
        System.out.println("\nEXAMPLE 2: " + Arrays.toString(nums));
        actual = debug.maxSubArray(nums);
        // The method has finished: actual=-2, expected=-2; nums is unchanged.
        System.out.printf("Expected=%d, actual=%d%n", expected, actual);
        if (actual != expected) throw new AssertionError("Example 2 failed");
    }
}
