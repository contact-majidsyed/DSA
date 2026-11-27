package practice.arrays_and_hashmaps.maximum_subarray;

/**
 * The original algorithm, with a debugger walkthrough written in comments.
 * No logging, extra tracking variables, or main method.
 * Read one iteration down through both assignments, then move to the next row.
 */
public class SolutionDebug {
    public long maxSubArray(int[] nums) {
        // EXAMPLE 1 from question.md
        // index:  0   1   2   3   4   5   6   7   8
        // nums:  -2   1  -3   4  -1   2   1  -5   4
        // Expected return: 6, from [4, -1, 2, 1].

        // nums.length = 9 -> condition is false -> continue below.
        if (nums.length == 0) throw new IllegalArgumentException("Empty input");

        long current = nums[0], best = nums[0];
        // AFTER this line: current = -2, best = -2.
        // current = largest sum of a stretch that MUST end at the visited index.
        // best    = largest sum found ANYWHERE so far.
        // Start from nums[0], not 0: choosing no elements is not allowed.

        // ===== LOOP START L1: for loop =====
        for (int i = 1; i < nums.length; i++) {
            // LOOP FLOW: check i < 9 -> update current -> update best -> i++.
            // First visit: i=1, nums[i]=1, current=-2, best=-2.
            // Index 0 was already handled by initialization.

            current = Math.max(nums[i], current + nums[i]);
            //                 start here   extend the previous stretch
            // The right side uses OLD current; assignment stores NEW current.
            //
            // Pause AFTER this line on each visit:
            // i  nums[i]  old current  calculation          new current  choice
            // 1     1         -2      max( 1, -2 +  1)          1       start
            // 2    -3          1      max(-3,  1 + -3)         -2       extend
            // 3     4         -2      max( 4, -2 +  4)          4       start
            // 4    -1          4      max(-1,  4 + -1)          3       extend
            // 5     2          3      max( 2,  3 +  2)          5       extend
            // 6     1          5      max( 1,  5 +  1)          6       extend
            // 7    -5          6      max(-5,  6 + -5)          1       extend
            // 8     4          1      max( 4,  1 +  4)          5       extend
            //
            // At i=3, discard the old negative sum and start at 4.
            // At i=4, KEEP -1: extending gives 3, better than starting at -1.
            // best has NOT changed yet. The next line updates it.

            best = Math.max(best, current);
            // This line uses NEW current from the assignment above.
            //
            // Pause AFTER this line on the SAME visit:
            // i   old best   new current   calculation    stored best
            // 1      -2           1        max(-2, 1)          1
            // 2       1          -2        max( 1,-2)          1
            // 3       1           4        max( 1, 4)          4
            // 4       4           3        max( 4, 3)          4
            // 5       4           5        max( 4, 5)          5
            // 6       5           6        max( 5, 6)          6
            // 7       6           1        max( 6, 1)          6
            // 8       6           5        max( 6, 5)          6
            //
            // At i=7, the moving stretch is [4,-1,2,1,-5], sum=1.
            // best still remembers [4,-1,2,1], sum=6.
            // These stretches are illustrations, not extra arrays in the code.

            // END OF VISIT: i++ runs, then the loop condition is checked again.
            // Example: after i=1, carry current=1 and best=1 into i=2.
            // After i=8, i becomes 9; 9 < 9 is false, so leave the loop.
        }
        // ===== LOOP END L1 =====

        // AFTER THE LOOP: current=5, best=6; loop-local i is out of scope.
        // current describes the best stretch ending at the FINAL element.
        // best remembers the winner even though it ended earlier, at index 6.
        return best; // Returns 6 to the caller. Nothing is printed.
    }

    /*
     * EXAMPLE 2 from question.md: nums = [-5, -2, -7], expected return = -2.
     * The SAME method runs; this is a second walkthrough, not extra code.
     *
     * Initialize: current=-5, best=-5.
     *
     * i=1, nums[i]=-2:
     *   current = max(-2, -5 + -2) = -2   -> start fresh
     *   best    = max(-5, -2)      = -2   -> save the new record
     *   i++ -> 2; 2 < 3 is true -> next visit
     *
     * i=2, nums[i]=-7:
     *   current = max(-7, -2 + -7) = -7   -> start fresh
     *   best    = max(-2, -7)      = -2   -> keep the earlier record
     *   i++ -> 3; 3 < 3 is false -> leave the loop
     *
     * Return best = -2. Returning current would give -7, which is wrong.
     * Initializing best to 0 would also be wrong: the subarray must be nonempty.
     */
}
