package practice.strings_and_sliding_window.longest_palindromic_substring;

import java.util.*;

/** Longest Palindromic Substring. See explanation.md for the contract and walkthrough. */
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, length = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);
            int candidate = Math.max(odd, even);
            if (candidate > length) {
                length = candidate;
                start = i - (candidate - 1) / 2;
            }
        }
        return s.substring(start, start + length);
    }
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
