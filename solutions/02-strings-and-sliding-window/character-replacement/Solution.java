package practice.strings_and_sliding_window.character_replacement;

import java.util.*;

/** Longest Repeating Character Replacement. See explanation.md for the contract and walkthrough. */
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxFrequency = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            maxFrequency = Math.max(maxFrequency, ++count[s.charAt(right) - 'A']);
            while (right - left + 1 - maxFrequency > k) {
                count[s.charAt(left++) - 'A']--;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
