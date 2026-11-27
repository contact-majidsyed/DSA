package practice.two_pointers_and_binary_search.valid_palindrome;

import java.util.*;

/** Valid Palindrome. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: s = "A man, a plan, a canal: Panama"
    //   Output: true
    // Example 2:
    //   Input: s = "race a car"
    //   Output: false
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public boolean isPalindrome(String s) {
        // For A man, a plan, a canal: Panama: left=0, right=29.
        int left = 0, right = s.length() - 1;
        // ===== LOOP START L1: while loop =====
        while (left < right) {
            // SKIP LEFT punctuation/spaces. After the first comparison left=1; this loop skips index 1 to reach m at 2.
            // ===== LOOP START L2: while loop =====
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            // ===== LOOP END L2 =====
            // SKIP RIGHT punctuation/spaces. Example: right=23 is a space -> move to 22, then skip colon to 21.
            // ===== LOOP START L3: while loop =====
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            // ===== LOOP END L3 =====
            // Compare index pairs after skipping: (0,29),(2,28),(3,27),(4,26),(7,25),
            // (9,24),(10,21),(11,20),(12,19),(15,18),(17,17). All match ignoring case.
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            // After comparing (15,18), move to left=16,right=17.
            // Next visit skips left space to 17; compare the center with itself, then cross.
            left++;
            right--;
        }
        // ===== LOOP END L1 =====
        // RETURN true. A mismatch would return false before the loop boundary.
        return true;
    }
}
