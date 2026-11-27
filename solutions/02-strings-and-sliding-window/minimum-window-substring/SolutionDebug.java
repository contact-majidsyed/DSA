package practice.strings_and_sliding_window.minimum_window_substring;

import java.util.*;

/** Minimum Window Substring. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: s = "ADOBECODEBANC", t = "ABC"
    //   Output: "BANC"
    // Example 2:
    //   Input: s = "a", t = "aa"
    //   Output: ""
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        Map<Character, Integer> need = new HashMap<>();
        // BUILD need: A -> {A:1}; B -> {A:1,B:1}; C -> {A:1,B:1,C:1}.
        // ===== LOOP START L1: for loop =====
        for (char c : t.toCharArray()) need.merge(c, 1, Integer::sum);
        // ===== LOOP END L1 =====
        // START missing=3, left=0, start=0, best=MAX_VALUE.
        int missing = t.length(), left = 0, start = 0, best = Integer.MAX_VALUE;
        // ===== LOOP START L2: for loop =====
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                // EXPANSION milestones: right=0(A) -> missing=2; 3(B) -> 1; 5(C) -> 0.
                // After the first shrink, right=10(A) completes coverage again; right=12(C) completes it a third time.
                if (need.get(c) > 0) missing--;
                need.put(c, need.get(c) - 1);
            }
            // SHRINK visits by right index: right=5 removes index 0; right=10 removes indices 1..5;
            // right=12 removes indices 6..9. Stop each time a required occurrence is lost.
            // ===== LOOP START L3: while loop =====
            while (missing == 0) {
                if (right - left + 1 < best) {
                    start = left;
                    // New records: right=5,left=0 -> start=0,best=6 (ADOBEC);
                    // right=12,left=8 -> start=8,best=5 (EBANC); left=9 -> start=9,best=4 (BANC).
                    best = right - left + 1;
                }
                char removed = s.charAt(left++);
                if (need.containsKey(removed)) {
                    need.put(removed, need.get(removed) + 1);
                    // After removing required A at 0, C at 5, or B at 9: missing becomes 1.
                    // Surplus copies have nonpositive demand and can be removed without breaking coverage.
                    if (need.get(removed) > 0) missing++;
                }
            }
            // ===== LOOP END L3 =====
        }
        // ===== LOOP END L2 =====
        // RETURN substring(9,13) = BANC.
        return best == Integer.MAX_VALUE ? "" : s.substring(start, start + best);
    }
}
