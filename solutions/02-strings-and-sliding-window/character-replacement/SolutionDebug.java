package practice.strings_and_sliding_window.character_replacement;

import java.util.*;

/** Longest Repeating Character Replacement. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: s = "AABABBA", k = 1
    //   Output: 4
    // Example 2:
    //   Input: s = "ABAB", k = 2
    //   Output: 4
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxFrequency = 0, best = 0;
        // ===== LOOP START L1: for loop =====
        for (int right = 0; right < s.length(); right++) {
            // For AABABBA, k=1: right=0..6 -> historical maxFrequency=1,2,2,3,3,3,3.
            maxFrequency = Math.max(maxFrequency, ++count[s.charAt(right) - 'A']);
            // ===== LOOP START L2: while loop =====
            while (right - left + 1 - maxFrequency > k) {
                // Shrink at right=4,5,6: remove indices 0,1,2 respectively.
                // left becomes 1,2,3. maxFrequency stays 3 even if the actual current maximum drops.
                count[s.charAt(left++) - 'A']--;
            }
            // ===== LOOP END L2 =====
            // AFTER each outer visit: (left,best)=(0,1),(0,2),(0,3),(0,4),(1,4),(2,4),(3,4).
            // The stale maximum is safe for the answer length; do not use this window as a guaranteed valid substring.
            best = Math.max(best, right - left + 1);
        }
        // ===== LOOP END L1 =====
        // RETURN 4; AABA can become AAAA with one replacement.
        return best;
    }
}
