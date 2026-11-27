package practice.two_pointers_and_binary_search.median_of_two_sorted_arrays;

import java.util.*;

/** Median of Two Sorted Arrays. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: a = [1,3], b = [2]
    //   Output: 2.0
    // Example 2:
    //   Input: a = [1,2], b = [3,4]
    //   Output: 2.5
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public double findMedianSortedArrays(int[] a, int[] b) {
        // CALL HANDOFF: Example 1 starts a=[1,3],b=[2]; swap once -> a=[2],b=[1,3].
        // The returned median is passed straight back to the original caller.
        if (a.length > b.length) return findMedianSortedArrays(b, a);
        int m = a.length, n = b.length;
        if (m + n == 0) throw new IllegalArgumentException("Both arrays empty");
        int low = 0, high = m;
        // ===== LOOP START L1: while loop =====
        while (low <= high) {
            // Visits in the swapped call: low=0,high=1 -> i=0; after moving low=1 -> i=1.
            int i = low + (high - low) / 2;
            // With m=1,n=2: j=2-i. Visit 1: j=2. Visit 2: j=1.
            int j = (m + n + 1) / 2 - i;
            int al = i == 0 ? Integer.MIN_VALUE : a[i - 1];
            int ar = i == m ? Integer.MAX_VALUE : a[i];
            int bl = j == 0 ? Integer.MIN_VALUE : b[j - 1];
            int br = j == n ? Integer.MAX_VALUE : b[j];
            // Boundary values by visit (MIN/MAX are int sentinels):
            // i=0,j=2: al=MIN,ar=2,bl=3,br=MAX -> bl>ar, move low to 1.
            // i=1,j=1: al=2,ar=MAX,bl=1,br=3 -> valid partition.
            if (al <= br && bl <= ar) {
                // EARLY RETURN: total length=3 is odd -> max(2,1)=2.0.
                if ((m + n) % 2 == 1) return Math.max(al, bl);
                // Example 2 has an even total: average left maximum 2 and right minimum 3 -> 2.5.
                return ((long) Math.max(al, bl) + Math.min(ar, br)) / 2.0;
            }
            if (al > br) high = i - 1;
            else low = i + 1;
        }
        // ===== LOOP END L1 =====
        throw new IllegalArgumentException("Arrays must be sorted");
    }
}
