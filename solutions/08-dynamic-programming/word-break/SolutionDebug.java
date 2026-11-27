// EARLY INNER-LOOP EXIT: one valid last word is enough. The outer loop still advances to the next end.
package practice.dynamic_programming.word_break;

import java.util.*;

/** Word Break. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: s = "leetcode", wordDict = ["leet","code"]
    //   Output: true
    // Example 2:
    //   Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    //   Output: false
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        // START dp[0]=true; all other slots false. Empty prefix is already segmented.
        dp[0] = true;
        // ===== LOOP START L1: for loop =====
        for (int end = 1; end <= s.length(); end++) {
            // ===== LOOP START L2: for loop =====
            for (String word : words) {
                // For leetcode and words leet/code (both length4), start=end-4.
                // end=1..3 gives negative start; end=4 gives 0; end=8 gives 4. Word iteration order is unspecified.
                int start = end - word.length();
                // end=4: dp[0]=true and leet matches -> success.
                // end=5..7: preceding dp slots are false. end=8: dp[4]=true and code matches -> success.
                if (start >= 0 && dp[start] && s.startsWith(word, start)) {
                    // AFTER outer visits 1..8: dp[end]=false,false,false,true,false,false,false,true.
                    dp[end] = true;
                    // EARLY INNER-LOOP EXIT: one valid last word is enough. The outer loop still advances to the next end.
                    break;
                }
            }
            // ===== LOOP END L2 =====
        }
        // ===== LOOP END L1 =====
        // RETURN dp[8]=true. Example 2 leaves its final prefix unreachable -> false.
        return dp[s.length()];
    }
}
