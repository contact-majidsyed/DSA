package practice.strings_and_sliding_window.minimum_window_substring;

import java.util.*;

/** Minimum Window Substring. See explanation.md for the contract and walkthrough. */
public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.merge(c, 1, Integer::sum);
        int missing = t.length(), left = 0, start = 0, best = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                if (need.get(c) > 0) missing--;
                need.put(c, need.get(c) - 1);
            }
            while (missing == 0) {
                if (right - left + 1 < best) {
                    start = left;
                    best = right - left + 1;
                }
                char removed = s.charAt(left++);
                if (need.containsKey(removed)) {
                    need.put(removed, need.get(removed) + 1);
                    if (need.get(removed) > 0) missing++;
                }
            }
        }
        return best == Integer.MAX_VALUE ? "" : s.substring(start, start + best);
    }
}
