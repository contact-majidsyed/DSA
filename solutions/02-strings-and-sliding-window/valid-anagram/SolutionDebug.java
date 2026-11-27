package practice.strings_and_sliding_window.valid_anagram;

import java.util.*;

/** Valid Anagram. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: s = "listen", t = "silent"
    //   Output: true
    // Example 2:
    //   Input: s = "aab", t = "abb"
    //   Output: false
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        // START: 26 zero slots. Positive means extra in s; negative means extra in t.
        int[] count = new int[26];
        // ===== LOOP START L1: for loop =====
        for (int i = 0; i < s.length(); i++) {
            // s=listen, t=silent. Each visit first adds the letter from s.
            count[s.charAt(i) - 'a']++;
            // AFTER both updates, nonzero slots only:
            // i=0: l=1,s=-1; i=1: l=1,s=-1; i=2: all zero;
            // i=3: t=1,e=-1; i=4: t=1,n=-1; i=5: all zero.
            count[t.charAt(i) - 'a']--;
        }
        // ===== LOOP END L1 =====
        // VERIFY LOOP: all 26 values are zero, so no early false return.
        // ===== LOOP START L2: for loop =====
        for (int n : count) if (n != 0) return false;
        // ===== LOOP END L2 =====
        // RETURN true; listen and silent have matching counts.
        return true;
    }
}
