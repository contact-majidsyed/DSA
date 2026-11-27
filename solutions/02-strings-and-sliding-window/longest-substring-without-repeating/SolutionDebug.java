package practice.strings_and_sliding_window.longest_substring_without_repeating;

import java.util.*;

/** Longest Substring Without Repeating Characters. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: s = "abcabcbb"
    //   Output: 3
    // Example 2:
    //   Input: s = "abba"
    //   Output: 2
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        // START: left=0, best=0, last={}.
        int left = 0, best = 0;
        // ===== LOOP START L1: for loop =====
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // For abcabcbb, right=0..7. After this line, left=0,0,0,1,2,3,5,7.
            // At right=6, b was at 4 -> left jumps to 5. Math.max prevents moving backward.
            if (last.containsKey(c)) left = Math.max(left, last.get(c) + 1);
            // Store this occurrence, replacing any earlier index for c.
            // At right=3: last={a:3,b:1,c:2}; at right=7: last={a:3,b:7,c:5}.
            last.put(c, right);
            // AFTER each visit: window lengths=1,2,3,3,3,3,2,1; best=1,2,3,3,3,3,3,3.
            best = Math.max(best, right - left + 1);
        }
        // ===== LOOP END L1 =====
        // RETURN 3; abc is one longest substring.
        return best;
    }
}
