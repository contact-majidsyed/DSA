package practice.arrays_and_hashmaps.group_anagrams;

import java.util.*;

/** Group Anagrams. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //   Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
    // Example 2:
    //   Input: strs = ["",""]
    //   Output: [["",""]]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // ===== LOOP START L1: for loop =====
        for (String s : strs) {
            // OUTER VISIT: s takes eat, tea, tan, ate, nat, bat in that order.
            // A NEW count=[0,...,0] (26 slots) is created for each word.
            int[] count = new int[26];
            // ===== LOOP START L2: for loop =====
            for (char c : s.toCharArray()) {
                // INNER VISITS for eat: c=e -> slot 4 becomes 1; c=a -> slot 0 becomes 1; c=t -> slot 19 becomes 1.
                // For tea: slots 19,4,0 become 1. Same final array despite different letter order.
                // For tan/nat: slots 0,13,19 are 1. For bat: slots 0,1,19 are 1.
                count[c - 'a']++;
            }
            // ===== LOOP END L2 =====
            // AFTER the inner loop: key is the full 26-count string, including zeros and separators.
            String key = Arrays.toString(count);
            // AFTER each outer visit, the affected group is:
            // eat -> [eat]; tea -> [eat,tea]; tan -> [tan]; ate -> [eat,tea,ate];
            // nat -> [tan,nat]; bat -> [bat]. Other groups keep their earlier values.
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        // ===== LOOP END L1 =====
        // RETURN three groups. HashMap group iteration order is unspecified.
        return new ArrayList<>(map.values());
    }
}
