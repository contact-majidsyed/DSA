package practice.strings_and_sliding_window.longest_palindromic_substring;

import java.util.*;

/** Longest Palindromic Substring. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: s = "babad"
    //   Output: "bab"
    // Example 2:
    //   Input: s = "cbbd"
    //   Output: "bb"
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public String longestPalindrome(String s) {
        int start = 0, length = 0;
        // ===== LOOP START L1: for loop =====
        for (int i = 0; i < s.length(); i++) {
            // OUTER VISITS for babad: i=0..4 -> odd lengths 1,3,3,1,1.
            int odd = expand(s, i, i);
            // The even-center helper returns 0 at every i for babad.
            int even = expand(s, i, i + 1);
            int candidate = Math.max(odd, even);
            // i=0 stores start=0,length=1. i=1 stores start=0,length=3.
            // i=2 ties length 3, so keep bab rather than replacing it with aba.
            if (candidate > length) {
                length = candidate;
                start = i - (candidate - 1) / 2;
            }
        }
        // ===== LOOP END L1 =====
        // FINAL RETURN substring(0,3) = bab.
        return s.substring(start, start + length);
    }
    private int expand(String s, int left, int right) {
        // HELPER WALK for center i=1: (left,right)=(1,1) matches a;
        // then (0,2) matches b; then (-1,3) is out of bounds -> stop.
        // ===== LOOP START L2: while loop =====
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // ===== LOOP END L2 =====
        // HELPER RETURN for i=1: 3-(-1)-1=3. The pointers stopped one position outside.
        return right - left - 1;
    }
}
