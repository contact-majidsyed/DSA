package practice.dynamic_programming.word_break;

import java.util.*;

/** Word Break. See explanation.md for the contract and walkthrough. */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int end = 1; end <= s.length(); end++) {
            for (String word : words) {
                int start = end - word.length();
                if (start >= 0 && dp[start] && s.startsWith(word, start)) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
