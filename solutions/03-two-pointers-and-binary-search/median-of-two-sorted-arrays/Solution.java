package practice.two_pointers_and_binary_search.median_of_two_sorted_arrays;

import java.util.*;

/** Median of Two Sorted Arrays. See explanation.md for the contract and walkthrough. */
public class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) return findMedianSortedArrays(b, a);
        int m = a.length, n = b.length;
        if (m + n == 0) throw new IllegalArgumentException("Both arrays empty");
        int low = 0, high = m;
        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = (m + n + 1) / 2 - i;
            int al = i == 0 ? Integer.MIN_VALUE : a[i - 1];
            int ar = i == m ? Integer.MAX_VALUE : a[i];
            int bl = j == 0 ? Integer.MIN_VALUE : b[j - 1];
            int br = j == n ? Integer.MAX_VALUE : b[j];
            if (al <= br && bl <= ar) {
                if ((m + n) % 2 == 1) return Math.max(al, bl);
                return ((long) Math.max(al, bl) + Math.min(ar, br)) / 2.0;
            }
            if (al > br) high = i - 1;
            else low = i + 1;
        }
        throw new IllegalArgumentException("Arrays must be sorted");
    }
}
