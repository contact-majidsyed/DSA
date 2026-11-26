package practice.strings_and_sliding_window.valid_anagram;

import java.util.*;

/** Valid Anagram. See explanation.md for the contract and walkthrough. */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int n : count) if (n != 0) return false;
        return true;
    }
}
